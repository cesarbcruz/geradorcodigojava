/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.geradorcodigojava;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import com.google.common.base.CaseFormat;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JEditorPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class TableToClass {

    private Map<String, String> mapaNomeColunaFormatada = new HashMap<String, String>();

    public void gerar(String ip, String banco, String usuario, String senha, String tabela, JEditorPane classe, JEditorPane insercao, JEditorPane remocao, JEditorPane cargaobjeto, JEditorPane leituraObjeto, JEditorPane metodoBuscar) {
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
                textoClasse.append("\n    private ").append(nameType).append(" ").append(formatarNomeColuna(name, false)).append(";");
                complemento.append("\n    public void set").append(formatarNomeColuna(name, true)).append("(").append(nameType).append(" ").append(formatarNomeColuna(name, false)).append("){");
                complemento.append("\n        this.").append(formatarNomeColuna(name, false)).append(" = ").append(formatarNomeColuna(name, false)).append(";");
                complemento.append("\n    }\n");
                complemento.append("\n    public ").append(nameType).append(" get").append(formatarNomeColuna(name, true)).append("(){");
                complemento.append("\n        return this.").append(formatarNomeColuna(name, false)).append(";");
                complemento.append("\n    }");
            }
            textoClasse.append("\n");
            textoClasse.append(complemento);
            textoClasse.append("\n");
            textoClasse.append("}");

            classe.setText(textoClasse.toString());

            DatabaseMetaData dm = con.getMetaData();
            String pkey = "<Não encontrou a chave>";
            ResultSet rsMeta = dm.getPrimaryKeys("", "", tabela.toLowerCase());
            while (rsMeta.next()) {
                pkey = rsMeta.getString("COLUMN_NAME");
            }
            rsMeta.close();

            insercao.setText(criarMetodoSalvarAtualizar(tabela, rsmd, pkey, con));
            cargaobjeto.setText(criarObjetoCarga(tabela, rsmd));
            leituraObjeto.setText(criarLeituraObjeto(tabela, rsmd));
            remocao.setText(criarMetodoExcluir(tabela, pkey));
            metodoBuscar.setText(criarMetodoBuscar(tabela, rsmd, pkey));

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

        retorno.append("\npublic void excluir" + tableName + "(int id" + tableName + ") throws ErpServerException {");
        retorno.append("\n    Connection con = null;");
        retorno.append("\n    PreparedStatement pstDelete = null;");
        retorno.append("\n    StringBuilder sql = new StringBuilder();");
        retorno.append("\n");
        retorno.append("\n    try {");
        retorno.append("\n");
        retorno.append("\n        con = conectaBDerp();");
        retorno.append("\n        sql.append(\"delete from " + tableName + " where " + pkey + " = ?\");");
        retorno.append("\n        pstDelete = con.prepareStatement(sql.toString());");
        retorno.append("\n");
        retorno.append("\n        pstDelete.setInt(1, id" + tableName + "); ");
        retorno.append("\n");
        retorno.append("\n        pstDelete.execute();");
        retorno.append("\n");
        retorno.append("\n    } catch (Exception ex) {");
        retorno.append("\n        throw ErpServerException.criar(ex);");
        retorno.append("\n    } finally {");
        retorno.append("\n        freeResources(null, pstDelete, con);");
        retorno.append("\n    }");
        retorno.append("\n}");

        return retorno.toString();
    }

    private String criarObjetoCarga(String tableName, ResultSetMetaData rsMetadata) throws Exception {
        StringBuilder retorno = new StringBuilder();
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            retorno.append("\n ").append(tableName).append(".set").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("(rs.get").append(setParam(rsMetadata.getColumnType(i))).append("(\"").append(formatarNomeColuna(rsMetadata.getColumnName(i), false)).append("\"));");
        }
        return retorno.toString();
    }

    private String criarMetodoBuscar(String tableName, ResultSetMetaData rsMetadata, String pKey) throws Exception {
        StringBuilder retorno = new StringBuilder();

        retorno.append("\n public " + tableName + " buscar" + tableName + "(int id" + tableName + ") throws ErpServerException {");
        retorno.append("\n Connection con = null;");
        retorno.append("\n PreparedStatement pstSelect = null;");
        retorno.append("\n StringBuilder sql = new StringBuilder();");
        retorno.append("\n ResultSet rs = null;");
        retorno.append("\n " + tableName + " " + tableName.toLowerCase() + " = null;");
        retorno.append("\n ");
        retorno.append("\n try {");
        retorno.append("\n ");
        retorno.append("\n     con = conectaBDerp();");
        retorno.append("\n     sql.append(\"select * from " + tableName + " where " + pKey + " = ?\");");
        retorno.append("\n     pstSelect = con.prepareStatement(sql.toString());");
        retorno.append("\n     pstSelect.setInt(1, id").append(tableName).append(");");
        retorno.append("\n     rs = pstSelect.executeQuery();");
        retorno.append("\n     while (rs.next()) {");
        retorno.append("\n             ").append(tableName.toLowerCase()).append(" = new ").append(tableName).append("();");
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            retorno.append("\n             ").append(tableName.toLowerCase()).append(".set").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("(rs.get").append(setParam(rsMetadata.getColumnType(i))).append("(\"").append(formatarNomeColuna(rsMetadata.getColumnName(i), false)).append("\"));");
        }
        retorno.append("\n         }");
        retorno.append("\n ");
        retorno.append("\n         return ").append(tableName.toLowerCase()).append(";");
        retorno.append("\n ");
        retorno.append("\n         } catch (Exception ex) {");
        retorno.append("\n              throw ErpServerException.criar(ex);");
        retorno.append("\n         } finally {");
        retorno.append("\n             freeResources(rs, pstSelect, con);");
        retorno.append("\n         }");
        retorno.append("\n     }");

        return retorno.toString();
    }

    private String criarLeituraObjeto(String tableName, ResultSetMetaData rsMetadata) throws Exception {
        StringBuilder retorno = new StringBuilder();
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            retorno.append("\n ").append(tableName).append(".get").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("();");
        }
        return retorno.toString();
    }

    private String criarMetodoSalvarAtualizar(String tableName, ResultSetMetaData rsMetadata, String pkey, Connection con) throws Exception {
        StringBuilder insertUpdateMetodo = new StringBuilder();

        insertUpdateMetodo.append("\n   private void salvar").append(tableName).append("(List<").append(tableName).append("> lista").append(tableName).append(") throws ErpServerException {");
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
        insertUpdateMetodo.append("\n         StringBuilder sql = new StringBuilder();");
        insertUpdateMetodo.append("\n         sql.append(\"insert into ").append(tableName).append("(\");");
        String parametros = "";
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            if (!rsMetadata.getColumnName(i).equals(pkey)) {
                String separador = "";
                parametros += "?";
                if (i <= rsMetadata.getColumnCount()) {
                    separador = ",";
                    parametros += ",";
                }
                insertUpdateMetodo.append("\n         sql.append(\"").append(formatarNomeColuna(rsMetadata.getColumnName(i), false)).append(separador).append("\");");
            }
        }
        insertUpdateMetodo.append("\n         sql.append(\"").append(pkey).append("\");");
        parametros += "?";
        insertUpdateMetodo.append("\n         sql.append(\") values (").append(parametros).append(") \");");
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
                insertUpdateMetodo.append("\n         sql.append(\"").append(formatarNomeColuna(rsMetadata.getColumnName(i), false)).append("=?").append(separador).append("\");");
            }
        }

        insertUpdateMetodo.append("\n         sql.append(\" where ").append(pkey).append(" = ? \");");

        insertUpdateMetodo.append("\n         pstUpdate = con.prepareStatement(sql.toString());");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n         final int batchSize = 1000;");
        insertUpdateMetodo.append("\n         int count = 0;");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n         for (").append(tableName).append(" ").append(tableName.toLowerCase()).append(" : lista").append(tableName).append(") {");
        insertUpdateMetodo.append("\n           if( ").append(tableName.toLowerCase()).append(".get").append(formatarNomeColuna(pkey, true)).append("() == 0 ){");
        insertUpdateMetodo.append("\n");
        insertUpdateMetodo.append("\n           rs = stm.executeQuery(\"SELECT nextval(('").append(tableName.toLowerCase()).append("_").append(pkey).append("_seq'::text)::regclass) as id\");");
        insertUpdateMetodo.append("\n           if (rs.next()) {");
        insertUpdateMetodo.append("\n               ").append(tableName.toLowerCase()).append(".set").append(formatarNomeColuna(pkey, true)).append("(rs.getInt(\"id\"));");
        insertUpdateMetodo.append("\n           }");
        insertUpdateMetodo.append("\n");
        int index = 0;
        StringBuilder insertSetPK = new StringBuilder();
        for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
            if (!rsMetadata.getColumnName(i).equals(pkey)) {
                int nullable = rsMetadata.isNullable(i);
                if (nullable == ResultSetMetaData.columnNullable && verificaColunaFK(con, tableName, rsMetadata.getColumnName(i))) {
                    int indice = ++index;
                    insertUpdateMetodo.append("\n              if(").append(tableName.toLowerCase()).append(".get").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("()").append(" > 0").append("){");
                    insertUpdateMetodo.append("\n                   pstInsert.set").append(setParam(rsMetadata.getColumnType(i))).append("(").append(indice).append(",  ").append(tableName.toLowerCase()).append(".get").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("());");
                    insertUpdateMetodo.append("\n              } else {");
                    insertUpdateMetodo.append("\n                   pstInsert.setNull").append("(").append(indice).append(",  ").append("java.sql.Types.BIGINT").append(");");
                    insertUpdateMetodo.append("\n              }");
                } else {
                    insertUpdateMetodo.append("\n              pstInsert.set").append(setParam(rsMetadata.getColumnType(i))).append("(").append(++index).append(",  ").append(tableName.toLowerCase()).append(".get").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("());");

                }
            } else {
                insertSetPK.append("\n              pstInsert.set").append(setParam(rsMetadata.getColumnType(i))).append("(").append(rsMetadata.getColumnCount()).append(",  ").append(tableName.toLowerCase()).append(".get").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("());");
            }
        }
        insertUpdateMetodo.append(insertSetPK);
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
                insertUpdateMetodo.append("\n              pstUpdate.set").append(setParam(rsMetadata.getColumnType(i))).append("(").append(++index).append(",  " + tableName.toLowerCase() + ".get").append(formatarNomeColuna(rsMetadata.getColumnName(i), true)).append("());");
            } else {
                where = "\n              pstUpdate.set" + setParam(rsMetadata.getColumnType(i)) + "(" + rsMetadata.getColumnCount() + ",  " + tableName.toLowerCase() + ".get" + formatarNomeColuna(rsMetadata.getColumnName(i), true) + "());";
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
        insertUpdateMetodo.append("\n        throw ErpServerException.criar(ex);");
        insertUpdateMetodo.append("\n     } finally {");
        insertUpdateMetodo.append("\n         freeResources(rs, stm, pstUpdate, pstInsert, con);");
        insertUpdateMetodo.append("\n     }");
        insertUpdateMetodo.append("\n   }");

        return insertUpdateMetodo.toString();
    }

    public boolean verificaColunaFK(Connection con, String tableName, String nomeColuna) throws SQLException {
        DatabaseMetaData dm = con.getMetaData();
        ResultSet rs = dm.getImportedKeys(null, null, tableName);
        
        while (rs.next()) {
            if (rs.getString("FKCOLUMN_NAME").equals(nomeColuna)) {
                return true;
            }
        }
        return false;
    }

    private String sqlTypeToJavaType(int columnType) {
        switch (columnType) {
            case java.sql.Types.INTEGER:
                return "int";
            case java.sql.Types.VARCHAR:
            case java.sql.Types.CHAR:
                return "String";
            case java.sql.Types.TIMESTAMP:
                return "Timestamp";
            case java.sql.Types.DATE:
                return "Date";
            case java.sql.Types.DOUBLE:
            case java.sql.Types.NUMERIC:
                return "BigDecimal";
            case java.sql.Types.BOOLEAN:
                return "boolean";
            case java.sql.Types.BIGINT:
                return "long";
            default:
                break;
        }

        return "nao_identificado";
    }

    private String setParam(int columnType) {
        switch (columnType) {
            case java.sql.Types.INTEGER:
                return "Int";
            case java.sql.Types.VARCHAR:
            case java.sql.Types.CHAR:
                return "String";
            case java.sql.Types.TIMESTAMP:
                return "Timestamp";
            case java.sql.Types.DATE:
                return "Date";
            case java.sql.Types.DOUBLE:
            case java.sql.Types.NUMERIC:
                return "BigDecimal";
            case java.sql.Types.BOOLEAN:
                return "Boolean";
            case java.sql.Types.BIGINT:
                return "Long";
            default:
                break;
        }

        return "nao_identificado";
    }

    public static void main(String[] args) {
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "THIS_IS_AN_EXAMPLE_STRING"));
    }

    void formatarNomeColunas(String ip, String banco, String usuario, String senha, String tabela, DefaultTableModel modeltabelaColunasFormatadas) {

        ResultSet rs = null;
        ResultSetMetaData rsMetadata = null;
        Connection con = null;
        Statement stmt = null;
        modeltabelaColunasFormatadas.setRowCount(0);
        mapaNomeColunaFormatada = new HashMap<String, String>();
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.setLoginTimeout(5);
            String url = "jdbc:postgresql://" + ip + "/" + banco;
            con = DriverManager.getConnection(url, usuario, senha);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from " + tabela + " limit 1");
            rsMetadata = rs.getMetaData();
            for (int i = 1; i < rsMetadata.getColumnCount() + 1; i++) {
                mapaNomeColunaFormatada.put(rsMetadata.getColumnName(i), rsMetadata.getColumnName(i));
                modeltabelaColunasFormatadas.addRow(new Object[]{rsMetadata.getColumnName(i), rsMetadata.getColumnName(i)});
            }

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

    private String formatarNomeColuna(String nomeColuna, boolean iniciaComMaiuscula) {
        String formatada = "";
        if (mapaNomeColunaFormatada.containsKey(nomeColuna)) {
            formatada = mapaNomeColunaFormatada.get(nomeColuna);
        }
        if (iniciaComMaiuscula && formatada != null && !formatada.isEmpty()) {
            formatada = formatada.substring(0, 1).toUpperCase() + formatada.substring(1);
        }
        return formatada;
    }

    public void atualizarMapaColunasFormatadas(DefaultTableModel modeloTabelaNomeColunas) {
        if (mapaNomeColunaFormatada != null && modeloTabelaNomeColunas != null && mapaNomeColunaFormatada.size() == modeloTabelaNomeColunas.getRowCount()) {
            for (int i = 0; i < modeloTabelaNomeColunas.getRowCount(); i++) {
                Object nomeColunaOriginal = modeloTabelaNomeColunas.getValueAt(i, 0);
                Object nomeColunaFormatada = modeloTabelaNomeColunas.getValueAt(i, 1);

                if (nomeColunaOriginal != null && nomeColunaFormatada != null && !nomeColunaFormatada.toString().isEmpty()) {
                    mapaNomeColunaFormatada.put(nomeColunaOriginal.toString(), nomeColunaFormatada.toString());
                }
            }
        }
    }
}
