/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.geradorcodigojava;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.sql.*;
import java.util.List;
import javax.swing.JEditorPane;

/**
 *
 * @author cesar
 */
public class TableToClass {

    public void gerar(String ip, String banco, String usuario, String senha, String tabela, JEditorPane classe, JEditorPane insercao, JEditorPane remocao, JEditorPane cargaobjeto, JEditorPane leituraObjeto) {
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        Connection con = null;
        Statement stmt = null;
        try {
            StringBuilder textoClasse = new StringBuilder();
            Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.setLoginTimeout(5);
            String url = "jdbc:postgresql://" + ip + "/" + banco;
            con = DriverManager.getConnection(url, usuario, senha);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from " + tabela + " limit 1");
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            StringBuilder complemento = new StringBuilder();
            textoClasse.append("\n");
            textoClasse.append("\npublic class " + tabela + " implements Serializable{");
            for (int i = 1; i < columnCount + 1; i++) {
                String name = rsmd.getColumnName(i);
                String nameType = sqlTypeToJavaType(rsmd.getColumnType(i));
                textoClasse.append("\n    private " + nameType + " " + name + ";");
                complemento.append("\n    public void set" + name + "(" + nameType + " " + name + "){");
                complemento.append("\n        this." + name + " = " + name + ";");
                complemento.append("\n    }\n");
                complemento.append("\n    public " + nameType + " get" + name + "(){");
                complemento.append("\n        return this." + name + ";");
                complemento.append("\n    }");
            }
            textoClasse.append("\n");
            textoClasse.append(complemento);
            textoClasse.append("\n");
            textoClasse.append("}");

            classe.setText(textoClasse.toString());

            DatabaseMetaData dm = con.getMetaData();
            String pkey = "<Não encontrou a chave>";
            ResultSet rsMeta = dm.getExportedKeys("", "", tabela);
            while (rsMeta.next()) {
                pkey = rsMeta.getString("PKCOLUMN_NAME");
            }
            rsMeta.close();

            insercao.setText(criarMetodoSalvarAtualizar(tabela, rsmd, pkey));
            cargaobjeto.setText(criarObjetoCarga(tabela, rsmd));
            leituraObjeto.setText(criarLeituraObjeto(tabela, rsmd));
            remocao.setText(criarMetodoExcluir(tabela, pkey));

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    private String criarMetodoExcluir(String tableName, String pkey) {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\n private void excluir"+tableName+"(List<"+tableName+"> lista"+tableName+") throws Exception {");
        retorno.append("\n Connection con = null;");
        retorno.append("\n PreparedStatement pstDelete = null;");
        retorno.append("\n StringBuilder sql = new StringBuilder();");
        retorno.append("\n ");
        retorno.append("\n try {");
        retorno.append("\n ");
        retorno.append("\n     con = conectaBDerp();          ");
        retorno.append("\n     sql.append(\"delete from "+tableName+" where "+pkey+" = ?\");            ");
        retorno.append("\n     pstDelete = con.prepareStatement(sql.toString());");
        retorno.append("\n ");
        retorno.append("\n     final int batchSize = 1000;");
        retorno.append("\n     int count = 0;");
        retorno.append("\n ");
        retorno.append("\n     for ("+tableName+" obj : lista"+tableName+") {");
        retorno.append("\n ");
        retorno.append("\n             pstDelete.setInt(1, obj.get"+pkey+"());");
        retorno.append("\n ");
        retorno.append("\n             pstDelete.addBatch();");
        retorno.append("\n             if (++count % batchSize == 0) {");
        retorno.append("\n                 pstDelete.executeBatch();");
        retorno.append("\n             }");
        retorno.append("\n     }");
        retorno.append("\n     ");
        retorno.append("\n     if (pstDelete != null) {");
        retorno.append("\n         pstDelete.executeBatch();");
        retorno.append("\n     }");
        retorno.append("\n ");
        retorno.append("\n } catch (Exception ex) {");
        retorno.append("\n        throw new Exception(ex.getMessage()+\"\\n\"+this.getClass().getName()+\".excluir" + tableName + "()\");");
        retorno.append("\n } finally {");
        retorno.append("\n     freeResources(null, pstDelete, con);");
        retorno.append("\n }");
        retorno.append("\n }");
        return retorno.toString();
    }

    private String criarObjetoCarga(String tableName, ResultSetMetaData rsMetadata) throws Exception {
        StringBuilder retorno = new StringBuilder();
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            retorno.append("\n " + tableName + ".set" + rsMetadata.getColumnName(i) + "(\"?\");");
        }
        return retorno.toString();
    }
    
    private String criarLeituraObjeto(String tableName, ResultSetMetaData rsMetadata) throws Exception {
        StringBuilder retorno = new StringBuilder();
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            retorno.append("\n " + tableName + ".get" + rsMetadata.getColumnName(i) + "();");
        }
        return retorno.toString();
    }

    private String criarMetodoSalvarAtualizar(String tableName, ResultSetMetaData rsMetadata, String pkey) throws Exception {
        StringBuilder insertUpdateMetodo = new StringBuilder();

        insertUpdateMetodo.append("\n   private void salvar" + tableName + "(List<" + tableName + "> lista" + tableName + ") throws Exception {");
        insertUpdateMetodo.append("\n     Connection con = null;");
        insertUpdateMetodo.append("\n     PreparedStatement pstInsert = null;");
        insertUpdateMetodo.append("\n     PreparedStatement pstUpdate = null;");
        insertUpdateMetodo.append("\n     Statement stm = null;");
        insertUpdateMetodo.append("\n     ResultSet rs = null;");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n     try {");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n         con = conectaBDerp();");
        insertUpdateMetodo.append("\n         stm = con.createStatement();");
        insertUpdateMetodo.append("\n         StringBuffer sql = new StringBuffer();");
        insertUpdateMetodo.append("\n         sql.append(\"insert into ").append(tableName).append("(\");");
        String parametros = "";
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            String separador = "";
            parametros += "?";
            if (i < rsMetadata.getColumnCount()) {
                separador = ",";
                parametros += ",";
            }
            insertUpdateMetodo.append("\n         sql.append(\"" + rsMetadata.getColumnName(i)).append(separador + "\");");
        }
        insertUpdateMetodo.append("\n         sql.append(\") values (" + parametros + ") \");");
        insertUpdateMetodo.append("\n         pstInsert = con.prepareStatement(sql.toString());");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n         sql.delete(0, sql.length());");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n         sql.append(\"update ").append(tableName).append(" set \");");
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            if (!rsMetadata.getColumnName(i).equals(pkey)) {
                String separador = "";
                if (i < rsMetadata.getColumnCount()) {
                    separador = ",";
                }
                insertUpdateMetodo.append("\n         sql.append(\"" + rsMetadata.getColumnName(i) + "=?" + separador + "\");");
            }
        }
        insertUpdateMetodo.append("\n         sql.append(\" where " + pkey + " = ? \");");

        insertUpdateMetodo.append("\n         pstUpdate = con.prepareStatement(sql.toString());");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n         final int batchSize = 1000;");
        insertUpdateMetodo.append("\n         int count = 0;");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n         for (" + tableName + " obj : lista" + tableName + ") {");
        insertUpdateMetodo.append("\n           if( obj.get" + pkey + "() == 0 ){");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n           rs = stm.executeQuery(\"SELECT nextval(('" + tableName + "_" + pkey + "_seq'::text)::regclass) as id\");");
        insertUpdateMetodo.append("\n           if (rs.next()) {");
        insertUpdateMetodo.append("\n               obj.set" + pkey + "(rs.getInt(\"id\"));");
        insertUpdateMetodo.append("\n           }");
        insertUpdateMetodo.append("\n");
        int index = 0;
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            if (!rsMetadata.getColumnName(i).equals(pkey)) {
                insertUpdateMetodo.append("\n              pstInsert.set" + setParam(rsMetadata.getColumnType(i)) + "(" + (++index) + ",  obj.get" + rsMetadata.getColumnName(i) + "());");
            }
        }
        insertUpdateMetodo.append("\n              pstInsert.addBatch();");
        insertUpdateMetodo.append("\n              if(++count % batchSize == 0) {");
        insertUpdateMetodo.append("\n                 pstInsert.executeBatch();");
        insertUpdateMetodo.append("\n              }");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n           }else{");
        insertUpdateMetodo.append("\n");
        index = 0;
        String where = "";
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            if (!rsMetadata.getColumnName(i).equals(pkey)) {
                insertUpdateMetodo.append("\n              pstUpdate.set" + setParam(rsMetadata.getColumnType(i)) + "(" + (++index) + ",  obj.get" + rsMetadata.getColumnName(i) + "());");
            } else {
                where = "\n              pstUpdate.set" + setParam(rsMetadata.getColumnType(i)) + "(" + rsMetadata.getColumnCount() + ",  obj.get" + rsMetadata.getColumnName(i) + "());";
            }
        }
        insertUpdateMetodo.append(where);
        insertUpdateMetodo.append("\n              pstUpdate.addBatch();");
        insertUpdateMetodo.append("\n              if(++count % batchSize == 0) {");
        insertUpdateMetodo.append("\n                 pstUpdate.executeBatch();");
        insertUpdateMetodo.append("\n              }");
        insertUpdateMetodo.append("\n           }");
        insertUpdateMetodo.append("\n         }");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n     if(pstInsert != null){");
        insertUpdateMetodo.append("\n         pstInsert.executeBatch();");
        insertUpdateMetodo.append("\n     }");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n     if(pstUpdate != null){");
        insertUpdateMetodo.append("\n         pstUpdate.executeBatch();");
        insertUpdateMetodo.append("\n     }");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n     }catch (Exception ex) {");
        insertUpdateMetodo.append("\n        throw new Exception(ex.getMessage()+\"\\n\"+this.getClass().getName()+\".salvar" + tableName + "()\");");
        insertUpdateMetodo.append("\n     } finally {");
        insertUpdateMetodo.append("\n         freeResources(rs, stm, null);");
        insertUpdateMetodo.append("\n         freeResources(null, pstUpdate, null);");
        insertUpdateMetodo.append("\n         freeResources(null, pstInsert, con);");
        insertUpdateMetodo.append("\n     }");
        insertUpdateMetodo.append("\n   }");

        return insertUpdateMetodo.toString();
    }

    private String sqlTypeToJavaType(int columnType) {
        if (columnType == java.sql.Types.INTEGER) {
            return "int";
        } else if (columnType == java.sql.Types.VARCHAR || columnType == java.sql.Types.CHAR) {
            return "String";
        } else if (columnType == java.sql.Types.TIMESTAMP) {
            return "Timestamp";
        } else if (columnType == java.sql.Types.DATE) {
            return "Date";
        } else if (columnType == java.sql.Types.DOUBLE || columnType == java.sql.Types.NUMERIC) {
            return "BigDecimal";
        } else if (columnType == java.sql.Types.BOOLEAN) {
            return "boolean";
        }

        return "nao_identificado";
    }

    private String setParam(int columnType) {
        if (columnType == java.sql.Types.INTEGER) {
            return "Int";
        } else if (columnType == java.sql.Types.VARCHAR || columnType == java.sql.Types.CHAR) {
            return "String";
        } else if (columnType == java.sql.Types.TIMESTAMP) {
            return "Timestamp";
        } else if (columnType == java.sql.Types.DATE) {
            return "Date";
        } else if (columnType == java.sql.Types.DOUBLE || columnType == java.sql.Types.NUMERIC) {
            return "BigDecimal";
        } else if (columnType == java.sql.Types.BOOLEAN) {
            return "Boolean";
        }

        return "nao_identificado";
    }
}
