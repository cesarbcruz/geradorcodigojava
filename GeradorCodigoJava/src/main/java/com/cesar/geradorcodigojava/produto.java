/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.geradorcodigojava;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author cesar
 */
public class produto implements Serializable {

    private int id;
    private int iddescricaoproduto;
    private int idsubcodigoproduto;
    private int idmarcaproduto;
    private int idsituacaoproduto;
    private int idsetorproduto;
    private int idtipoproduto;
    private int idgrupoproduto;
    private int idsubgrupoproduto;
    private int idclasseproduto;
    private int idunidadeproduto;
    private int idutilizacaoproduto;
    private String codigobarras;
    private String descricaoproduto;
    private String descricaopdv;
    private String controlarestoque;
    private BigDecimal percsobrepreco;
    private String emitiretiquetagondola;
    private BigDecimal peso;
    private int validade;
    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal profundidade;
    private int idusuarioinclusao;
    private String datahorainclusao;
    private int idusuarioaprovacaocad;
    private int idusuarioaprovacaocomercial;
    private int idusuarioaprovacaofiscalcontabil;
    private String datahoraaprovacaocad;
    private String datahoraaprovacaocomercial;
    private String datahoraaprovacaofiscalcontabil;
    private String etiquetacomfragrancia;
    private String fragranciacaracteristica;
    private String descricaoprodutoagricola;
    private int idprincipalmaster;
    private int idclassificacaofiscal;
    private String emitiretiquetabalanca;
    private String descricaoetiquetabalanca;
    private int numeroetiquetasimpressao;
    private int idunidadepeso;
    private String descricaoetiquetagondolasemfragrancia;
    private String descricaoetiquetagondolacomfragrancia1;
    private String descricaoetiquetagondolacomfragrancia2;
    private int idsetorbalanca;
    private String caracteristica;
    private int idgrupomaterialconsumo;
    private String descricaoembalagem;
    private BigDecimal precovendavarejo;
    private int idtipoitem;
    private int idunidadeinventario;
    private BigDecimal aliquotaipi;
    private String exigeaprovacaopedido;
    private int iddiretor;
    private int idtiporateiodefault;
    private String exigepedido;
    private String descontinuado;
    private String atualizacaoprecosautomatica;
    private String comercializadorestaurante;
    private int idprodutorevenda;
    private String parametrizacaofiscalalterada;
    private String datahoraparametrizacaofiscalalterada;
    private int idusuarioaprovacaoalteracaocadastro;
    private String datahoraaprovacaoalteracaocadastro;
    private String tipopedido;
    private int idtipolocalcompra;
    private int idcodigonaturezareceita;
    private BigDecimal pesopedido;
    private int idunidadepesopedido;
    private int idtipoprodutoinsumoproducaointerna;
    private int idunidademedidaconsumoproducaointerna;
    private BigDecimal quantidadeembalagemcomprainsumo;
    private String codigounico;
    private int idcorfundotransferenciacodigorgb;
    private String descricaocomercial;
    private int quantidadeinfnutri;
    private int idunidadeporcaoinfnutri;
    private int parteinteirainfnutri;
    private int idpartedecimalinfnutri;
    private int idmedidacaseirainfnutri;
    private int valorenergeticoinfnutri;
    private BigDecimal carboidratosinfnutri;
    private BigDecimal proteinasinfnutri;
    private BigDecimal gordurastotaisinfnutri;
    private BigDecimal gordurassaturadasinfnutri;
    private BigDecimal gordurastransinfnutri;
    private BigDecimal fibraalimentarinfnutri;
    private BigDecimal sodioinfnutri;

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return this.id;
    }

    public void setiddescricaoproduto(int iddescricaoproduto) {
        this.iddescricaoproduto = iddescricaoproduto;
    }

    public int getiddescricaoproduto() {
        return this.iddescricaoproduto;
    }

    public void setidsubcodigoproduto(int idsubcodigoproduto) {
        this.idsubcodigoproduto = idsubcodigoproduto;
    }

    public int getidsubcodigoproduto() {
        return this.idsubcodigoproduto;
    }

    public void setidmarcaproduto(int idmarcaproduto) {
        this.idmarcaproduto = idmarcaproduto;
    }

    public int getidmarcaproduto() {
        return this.idmarcaproduto;
    }

    public void setidsituacaoproduto(int idsituacaoproduto) {
        this.idsituacaoproduto = idsituacaoproduto;
    }

    public int getidsituacaoproduto() {
        return this.idsituacaoproduto;
    }

    public void setidsetorproduto(int idsetorproduto) {
        this.idsetorproduto = idsetorproduto;
    }

    public int getidsetorproduto() {
        return this.idsetorproduto;
    }

    public void setidtipoproduto(int idtipoproduto) {
        this.idtipoproduto = idtipoproduto;
    }

    public int getidtipoproduto() {
        return this.idtipoproduto;
    }

    public void setidgrupoproduto(int idgrupoproduto) {
        this.idgrupoproduto = idgrupoproduto;
    }

    public int getidgrupoproduto() {
        return this.idgrupoproduto;
    }

    public void setidsubgrupoproduto(int idsubgrupoproduto) {
        this.idsubgrupoproduto = idsubgrupoproduto;
    }

    public int getidsubgrupoproduto() {
        return this.idsubgrupoproduto;
    }

    public void setidclasseproduto(int idclasseproduto) {
        this.idclasseproduto = idclasseproduto;
    }

    public int getidclasseproduto() {
        return this.idclasseproduto;
    }

    public void setidunidadeproduto(int idunidadeproduto) {
        this.idunidadeproduto = idunidadeproduto;
    }

    public int getidunidadeproduto() {
        return this.idunidadeproduto;
    }

    public void setidutilizacaoproduto(int idutilizacaoproduto) {
        this.idutilizacaoproduto = idutilizacaoproduto;
    }

    public int getidutilizacaoproduto() {
        return this.idutilizacaoproduto;
    }

    public void setcodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getcodigobarras() {
        return this.codigobarras;
    }

    public void setdescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public String getdescricaoproduto() {
        return this.descricaoproduto;
    }

    public void setdescricaopdv(String descricaopdv) {
        this.descricaopdv = descricaopdv;
    }

    public String getdescricaopdv() {
        return this.descricaopdv;
    }

    public void setcontrolarestoque(String controlarestoque) {
        this.controlarestoque = controlarestoque;
    }

    public String getcontrolarestoque() {
        return this.controlarestoque;
    }

    public void setpercsobrepreco(BigDecimal percsobrepreco) {
        this.percsobrepreco = percsobrepreco;
    }

    public BigDecimal getpercsobrepreco() {
        return this.percsobrepreco;
    }

    public void setemitiretiquetagondola(String emitiretiquetagondola) {
        this.emitiretiquetagondola = emitiretiquetagondola;
    }

    public String getemitiretiquetagondola() {
        return this.emitiretiquetagondola;
    }

    public void setpeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getpeso() {
        return this.peso;
    }

    public void setvalidade(int validade) {
        this.validade = validade;
    }

    public int getvalidade() {
        return this.validade;
    }

    public void setaltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getaltura() {
        return this.altura;
    }

    public void setlargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getlargura() {
        return this.largura;
    }

    public void setprofundidade(BigDecimal profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getprofundidade() {
        return this.profundidade;
    }

    public void setidusuarioinclusao(int idusuarioinclusao) {
        this.idusuarioinclusao = idusuarioinclusao;
    }

    public int getidusuarioinclusao() {
        return this.idusuarioinclusao;
    }

    public void setdatahorainclusao(String datahorainclusao) {
        this.datahorainclusao = datahorainclusao;
    }

    public String getdatahorainclusao() {
        return this.datahorainclusao;
    }

    public void setidusuarioaprovacaocad(int idusuarioaprovacaocad) {
        this.idusuarioaprovacaocad = idusuarioaprovacaocad;
    }

    public int getidusuarioaprovacaocad() {
        return this.idusuarioaprovacaocad;
    }

    public void setidusuarioaprovacaocomercial(int idusuarioaprovacaocomercial) {
        this.idusuarioaprovacaocomercial = idusuarioaprovacaocomercial;
    }

    public int getidusuarioaprovacaocomercial() {
        return this.idusuarioaprovacaocomercial;
    }

    public void setidusuarioaprovacaofiscalcontabil(int idusuarioaprovacaofiscalcontabil) {
        this.idusuarioaprovacaofiscalcontabil = idusuarioaprovacaofiscalcontabil;
    }

    public int getidusuarioaprovacaofiscalcontabil() {
        return this.idusuarioaprovacaofiscalcontabil;
    }

    public void setdatahoraaprovacaocad(String datahoraaprovacaocad) {
        this.datahoraaprovacaocad = datahoraaprovacaocad;
    }

    public String getdatahoraaprovacaocad() {
        return this.datahoraaprovacaocad;
    }

    public void setdatahoraaprovacaocomercial(String datahoraaprovacaocomercial) {
        this.datahoraaprovacaocomercial = datahoraaprovacaocomercial;
    }

    public String getdatahoraaprovacaocomercial() {
        return this.datahoraaprovacaocomercial;
    }

    public void setdatahoraaprovacaofiscalcontabil(String datahoraaprovacaofiscalcontabil) {
        this.datahoraaprovacaofiscalcontabil = datahoraaprovacaofiscalcontabil;
    }

    public String getdatahoraaprovacaofiscalcontabil() {
        return this.datahoraaprovacaofiscalcontabil;
    }

    public void setetiquetacomfragrancia(String etiquetacomfragrancia) {
        this.etiquetacomfragrancia = etiquetacomfragrancia;
    }

    public String getetiquetacomfragrancia() {
        return this.etiquetacomfragrancia;
    }

    public void setfragranciacaracteristica(String fragranciacaracteristica) {
        this.fragranciacaracteristica = fragranciacaracteristica;
    }

    public String getfragranciacaracteristica() {
        return this.fragranciacaracteristica;
    }

    public void setdescricaoprodutoagricola(String descricaoprodutoagricola) {
        this.descricaoprodutoagricola = descricaoprodutoagricola;
    }

    public String getdescricaoprodutoagricola() {
        return this.descricaoprodutoagricola;
    }

    public void setidprincipalmaster(int idprincipalmaster) {
        this.idprincipalmaster = idprincipalmaster;
    }

    public int getidprincipalmaster() {
        return this.idprincipalmaster;
    }

    public void setidclassificacaofiscal(int idclassificacaofiscal) {
        this.idclassificacaofiscal = idclassificacaofiscal;
    }

    public int getidclassificacaofiscal() {
        return this.idclassificacaofiscal;
    }

    public void setemitiretiquetabalanca(String emitiretiquetabalanca) {
        this.emitiretiquetabalanca = emitiretiquetabalanca;
    }

    public String getemitiretiquetabalanca() {
        return this.emitiretiquetabalanca;
    }

    public void setdescricaoetiquetabalanca(String descricaoetiquetabalanca) {
        this.descricaoetiquetabalanca = descricaoetiquetabalanca;
    }

    public String getdescricaoetiquetabalanca() {
        return this.descricaoetiquetabalanca;
    }

    public void setnumeroetiquetasimpressao(int numeroetiquetasimpressao) {
        this.numeroetiquetasimpressao = numeroetiquetasimpressao;
    }

    public int getnumeroetiquetasimpressao() {
        return this.numeroetiquetasimpressao;
    }

    public void setidunidadepeso(int idunidadepeso) {
        this.idunidadepeso = idunidadepeso;
    }

    public int getidunidadepeso() {
        return this.idunidadepeso;
    }

    public void setdescricaoetiquetagondolasemfragrancia(String descricaoetiquetagondolasemfragrancia) {
        this.descricaoetiquetagondolasemfragrancia = descricaoetiquetagondolasemfragrancia;
    }

    public String getdescricaoetiquetagondolasemfragrancia() {
        return this.descricaoetiquetagondolasemfragrancia;
    }

    public void setdescricaoetiquetagondolacomfragrancia1(String descricaoetiquetagondolacomfragrancia1) {
        this.descricaoetiquetagondolacomfragrancia1 = descricaoetiquetagondolacomfragrancia1;
    }

    public String getdescricaoetiquetagondolacomfragrancia1() {
        return this.descricaoetiquetagondolacomfragrancia1;
    }

    public void setdescricaoetiquetagondolacomfragrancia2(String descricaoetiquetagondolacomfragrancia2) {
        this.descricaoetiquetagondolacomfragrancia2 = descricaoetiquetagondolacomfragrancia2;
    }

    public String getdescricaoetiquetagondolacomfragrancia2() {
        return this.descricaoetiquetagondolacomfragrancia2;
    }

    public void setidsetorbalanca(int idsetorbalanca) {
        this.idsetorbalanca = idsetorbalanca;
    }

    public int getidsetorbalanca() {
        return this.idsetorbalanca;
    }

    public void setcaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getcaracteristica() {
        return this.caracteristica;
    }

    public void setidgrupomaterialconsumo(int idgrupomaterialconsumo) {
        this.idgrupomaterialconsumo = idgrupomaterialconsumo;
    }

    public int getidgrupomaterialconsumo() {
        return this.idgrupomaterialconsumo;
    }

    public void setdescricaoembalagem(String descricaoembalagem) {
        this.descricaoembalagem = descricaoembalagem;
    }

    public String getdescricaoembalagem() {
        return this.descricaoembalagem;
    }

    public void setprecovendavarejo(BigDecimal precovendavarejo) {
        this.precovendavarejo = precovendavarejo;
    }

    public BigDecimal getprecovendavarejo() {
        return this.precovendavarejo;
    }

    public void setidtipoitem(int idtipoitem) {
        this.idtipoitem = idtipoitem;
    }

    public int getidtipoitem() {
        return this.idtipoitem;
    }

    public void setidunidadeinventario(int idunidadeinventario) {
        this.idunidadeinventario = idunidadeinventario;
    }

    public int getidunidadeinventario() {
        return this.idunidadeinventario;
    }

    public void setaliquotaipi(BigDecimal aliquotaipi) {
        this.aliquotaipi = aliquotaipi;
    }

    public BigDecimal getaliquotaipi() {
        return this.aliquotaipi;
    }

    public void setexigeaprovacaopedido(String exigeaprovacaopedido) {
        this.exigeaprovacaopedido = exigeaprovacaopedido;
    }

    public String getexigeaprovacaopedido() {
        return this.exigeaprovacaopedido;
    }

    public void setiddiretor(int iddiretor) {
        this.iddiretor = iddiretor;
    }

    public int getiddiretor() {
        return this.iddiretor;
    }

    public void setidtiporateiodefault(int idtiporateiodefault) {
        this.idtiporateiodefault = idtiporateiodefault;
    }

    public int getidtiporateiodefault() {
        return this.idtiporateiodefault;
    }

    public void setexigepedido(String exigepedido) {
        this.exigepedido = exigepedido;
    }

    public String getexigepedido() {
        return this.exigepedido;
    }

    public void setdescontinuado(String descontinuado) {
        this.descontinuado = descontinuado;
    }

    public String getdescontinuado() {
        return this.descontinuado;
    }

    public void setatualizacaoprecosautomatica(String atualizacaoprecosautomatica) {
        this.atualizacaoprecosautomatica = atualizacaoprecosautomatica;
    }

    public String getatualizacaoprecosautomatica() {
        return this.atualizacaoprecosautomatica;
    }

    public void setcomercializadorestaurante(String comercializadorestaurante) {
        this.comercializadorestaurante = comercializadorestaurante;
    }

    public String getcomercializadorestaurante() {
        return this.comercializadorestaurante;
    }

    public void setidprodutorevenda(int idprodutorevenda) {
        this.idprodutorevenda = idprodutorevenda;
    }

    public int getidprodutorevenda() {
        return this.idprodutorevenda;
    }

    public void setparametrizacaofiscalalterada(String parametrizacaofiscalalterada) {
        this.parametrizacaofiscalalterada = parametrizacaofiscalalterada;
    }

    public String getparametrizacaofiscalalterada() {
        return this.parametrizacaofiscalalterada;
    }

    public void setdatahoraparametrizacaofiscalalterada(String datahoraparametrizacaofiscalalterada) {
        this.datahoraparametrizacaofiscalalterada = datahoraparametrizacaofiscalalterada;
    }

    public String getdatahoraparametrizacaofiscalalterada() {
        return this.datahoraparametrizacaofiscalalterada;
    }

    public void setidusuarioaprovacaoalteracaocadastro(int idusuarioaprovacaoalteracaocadastro) {
        this.idusuarioaprovacaoalteracaocadastro = idusuarioaprovacaoalteracaocadastro;
    }

    public int getidusuarioaprovacaoalteracaocadastro() {
        return this.idusuarioaprovacaoalteracaocadastro;
    }

    public void setdatahoraaprovacaoalteracaocadastro(String datahoraaprovacaoalteracaocadastro) {
        this.datahoraaprovacaoalteracaocadastro = datahoraaprovacaoalteracaocadastro;
    }

    public String getdatahoraaprovacaoalteracaocadastro() {
        return this.datahoraaprovacaoalteracaocadastro;
    }

    public void settipopedido(String tipopedido) {
        this.tipopedido = tipopedido;
    }

    public String gettipopedido() {
        return this.tipopedido;
    }

    public void setidtipolocalcompra(int idtipolocalcompra) {
        this.idtipolocalcompra = idtipolocalcompra;
    }

    public int getidtipolocalcompra() {
        return this.idtipolocalcompra;
    }

    public void setidcodigonaturezareceita(int idcodigonaturezareceita) {
        this.idcodigonaturezareceita = idcodigonaturezareceita;
    }

    public int getidcodigonaturezareceita() {
        return this.idcodigonaturezareceita;
    }

    public void setpesopedido(BigDecimal pesopedido) {
        this.pesopedido = pesopedido;
    }

    public BigDecimal getpesopedido() {
        return this.pesopedido;
    }

    public void setidunidadepesopedido(int idunidadepesopedido) {
        this.idunidadepesopedido = idunidadepesopedido;
    }

    public int getidunidadepesopedido() {
        return this.idunidadepesopedido;
    }

    public void setidtipoprodutoinsumoproducaointerna(int idtipoprodutoinsumoproducaointerna) {
        this.idtipoprodutoinsumoproducaointerna = idtipoprodutoinsumoproducaointerna;
    }

    public int getidtipoprodutoinsumoproducaointerna() {
        return this.idtipoprodutoinsumoproducaointerna;
    }

    public void setidunidademedidaconsumoproducaointerna(int idunidademedidaconsumoproducaointerna) {
        this.idunidademedidaconsumoproducaointerna = idunidademedidaconsumoproducaointerna;
    }

    public int getidunidademedidaconsumoproducaointerna() {
        return this.idunidademedidaconsumoproducaointerna;
    }

    public void setquantidadeembalagemcomprainsumo(BigDecimal quantidadeembalagemcomprainsumo) {
        this.quantidadeembalagemcomprainsumo = quantidadeembalagemcomprainsumo;
    }

    public BigDecimal getquantidadeembalagemcomprainsumo() {
        return this.quantidadeembalagemcomprainsumo;
    }

    public void setcodigounico(String codigounico) {
        this.codigounico = codigounico;
    }

    public String getcodigounico() {
        return this.codigounico;
    }

    public void setidcorfundotransferenciacodigorgb(int idcorfundotransferenciacodigorgb) {
        this.idcorfundotransferenciacodigorgb = idcorfundotransferenciacodigorgb;
    }

    public int getidcorfundotransferenciacodigorgb() {
        return this.idcorfundotransferenciacodigorgb;
    }

    public void setdescricaocomercial(String descricaocomercial) {
        this.descricaocomercial = descricaocomercial;
    }

    public String getdescricaocomercial() {
        return this.descricaocomercial;
    }

    public void setquantidadeinfnutri(int quantidadeinfnutri) {
        this.quantidadeinfnutri = quantidadeinfnutri;
    }

    public int getquantidadeinfnutri() {
        return this.quantidadeinfnutri;
    }

    public void setidunidadeporcaoinfnutri(int idunidadeporcaoinfnutri) {
        this.idunidadeporcaoinfnutri = idunidadeporcaoinfnutri;
    }

    public int getidunidadeporcaoinfnutri() {
        return this.idunidadeporcaoinfnutri;
    }

    public void setparteinteirainfnutri(int parteinteirainfnutri) {
        this.parteinteirainfnutri = parteinteirainfnutri;
    }

    public int getparteinteirainfnutri() {
        return this.parteinteirainfnutri;
    }

    public void setidpartedecimalinfnutri(int idpartedecimalinfnutri) {
        this.idpartedecimalinfnutri = idpartedecimalinfnutri;
    }

    public int getidpartedecimalinfnutri() {
        return this.idpartedecimalinfnutri;
    }

    public void setidmedidacaseirainfnutri(int idmedidacaseirainfnutri) {
        this.idmedidacaseirainfnutri = idmedidacaseirainfnutri;
    }

    public int getidmedidacaseirainfnutri() {
        return this.idmedidacaseirainfnutri;
    }

    public void setvalorenergeticoinfnutri(int valorenergeticoinfnutri) {
        this.valorenergeticoinfnutri = valorenergeticoinfnutri;
    }

    public int getvalorenergeticoinfnutri() {
        return this.valorenergeticoinfnutri;
    }

    public void setcarboidratosinfnutri(BigDecimal carboidratosinfnutri) {
        this.carboidratosinfnutri = carboidratosinfnutri;
    }

    public BigDecimal getcarboidratosinfnutri() {
        return this.carboidratosinfnutri;
    }

    public void setproteinasinfnutri(BigDecimal proteinasinfnutri) {
        this.proteinasinfnutri = proteinasinfnutri;
    }

    public BigDecimal getproteinasinfnutri() {
        return this.proteinasinfnutri;
    }

    public void setgordurastotaisinfnutri(BigDecimal gordurastotaisinfnutri) {
        this.gordurastotaisinfnutri = gordurastotaisinfnutri;
    }

    public BigDecimal getgordurastotaisinfnutri() {
        return this.gordurastotaisinfnutri;
    }

    public void setgordurassaturadasinfnutri(BigDecimal gordurassaturadasinfnutri) {
        this.gordurassaturadasinfnutri = gordurassaturadasinfnutri;
    }

    public BigDecimal getgordurassaturadasinfnutri() {
        return this.gordurassaturadasinfnutri;
    }

    public void setgordurastransinfnutri(BigDecimal gordurastransinfnutri) {
        this.gordurastransinfnutri = gordurastransinfnutri;
    }

    public BigDecimal getgordurastransinfnutri() {
        return this.gordurastransinfnutri;
    }

    public void setfibraalimentarinfnutri(BigDecimal fibraalimentarinfnutri) {
        this.fibraalimentarinfnutri = fibraalimentarinfnutri;
    }

    public BigDecimal getfibraalimentarinfnutri() {
        return this.fibraalimentarinfnutri;
    }

    public void setsodioinfnutri(BigDecimal sodioinfnutri) {
        this.sodioinfnutri = sodioinfnutri;
    }

    public BigDecimal getsodioinfnutri() {
        return this.sodioinfnutri;
    }

    private void salvarproduto(List<produto> listaproduto) throws Exception {
        Connection con = null;
        PreparedStatement pstInsert = null;
        PreparedStatement pstUpdate = null;

        try {

            con = conectaBDerp();
            StringBuffer sql = new StringBuffer();
            sql.append("insert into produto(");
            sql.append("iddescricaoproduto,");
            sql.append("idsubcodigoproduto,");
            sql.append("idmarcaproduto,");
            sql.append("idsituacaoproduto,");
            sql.append("idsetorproduto,");
            sql.append("idtipoproduto,");
            sql.append("idgrupoproduto,");
            sql.append("idsubgrupoproduto,");
            sql.append("idclasseproduto,");
            sql.append("idunidadeproduto,");
            sql.append("idutilizacaoproduto,");
            sql.append("codigobarras,");
            sql.append("descricaoproduto,");
            sql.append("descricaopdv,");
            sql.append("controlarestoque,");
            sql.append("percsobrepreco,");
            sql.append("emitiretiquetagondola,");
            sql.append("peso,");
            sql.append("validade,");
            sql.append("altura,");
            sql.append("largura,");
            sql.append("profundidade,");
            sql.append("idusuarioinclusao,");
            sql.append("datahorainclusao,");
            sql.append("idusuarioaprovacaocad,");
            sql.append("idusuarioaprovacaocomercial,");
            sql.append("idusuarioaprovacaofiscalcontabil,");
            sql.append("datahoraaprovacaocad,");
            sql.append("datahoraaprovacaocomercial,");
            sql.append("datahoraaprovacaofiscalcontabil,");
            sql.append("etiquetacomfragrancia,");
            sql.append("fragranciacaracteristica,");
            sql.append("descricaoprodutoagricola,");
            sql.append("idprincipalmaster,");
            sql.append("idclassificacaofiscal,");
            sql.append("emitiretiquetabalanca,");
            sql.append("descricaoetiquetabalanca,");
            sql.append("numeroetiquetasimpressao,");
            sql.append("idunidadepeso,");
            sql.append("descricaoetiquetagondolasemfragrancia,");
            sql.append("descricaoetiquetagondolacomfragrancia1,");
            sql.append("descricaoetiquetagondolacomfragrancia2,");
            sql.append("idsetorbalanca,");
            sql.append("caracteristica,");
            sql.append("idgrupomaterialconsumo,");
            sql.append("descricaoembalagem,");
            sql.append("precovendavarejo,");
            sql.append("idtipoitem,");
            sql.append("idunidadeinventario,");
            sql.append("aliquotaipi,");
            sql.append("exigeaprovacaopedido,");
            sql.append("iddiretor,");
            sql.append("idtiporateiodefault,");
            sql.append("exigepedido,");
            sql.append("descontinuado,");
            sql.append("atualizacaoprecosautomatica,");
            sql.append("comercializadorestaurante,");
            sql.append("idprodutorevenda,");
            sql.append("parametrizacaofiscalalterada,");
            sql.append("datahoraparametrizacaofiscalalterada,");
            sql.append("idusuarioaprovacaoalteracaocadastro,");
            sql.append("datahoraaprovacaoalteracaocadastro,");
            sql.append("tipopedido,");
            sql.append("idtipolocalcompra,");
            sql.append("idcodigonaturezareceita,");
            sql.append("pesopedido,");
            sql.append("idunidadepesopedido,");
            sql.append("idtipoprodutoinsumoproducaointerna,");
            sql.append("idunidademedidaconsumoproducaointerna,");
            sql.append("quantidadeembalagemcomprainsumo,");
            sql.append("codigounico,");
            sql.append("idcorfundotransferenciacodigorgb,");
            sql.append("descricaocomercial,");
            sql.append("quantidadeinfnutri,");
            sql.append("idunidadeporcaoinfnutri,");
            sql.append("parteinteirainfnutri,");
            sql.append("idpartedecimalinfnutri,");
            sql.append("idmedidacaseirainfnutri,");
            sql.append("valorenergeticoinfnutri,");
            sql.append("carboidratosinfnutri,");
            sql.append("proteinasinfnutri,");
            sql.append("gordurastotaisinfnutri,");
            sql.append("gordurassaturadasinfnutri,");
            sql.append("gordurastransinfnutri,");
            sql.append("fibraalimentarinfnutri,");
            sql.append("sodioinfnutri");
            sql.append(") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            pstInsert = con.prepareStatement(sql.toString());

            sql.delete(0, sql.length());

            sql.append("update produto set");
            sql.append("iddescricaoproduto=?,");
            sql.append("idsubcodigoproduto=?,");
            sql.append("idmarcaproduto=?,");
            sql.append("idsituacaoproduto=?,");
            sql.append("idsetorproduto=?,");
            sql.append("idtipoproduto=?,");
            sql.append("idgrupoproduto=?,");
            sql.append("idsubgrupoproduto=?,");
            sql.append("idclasseproduto=?,");
            sql.append("idunidadeproduto=?,");
            sql.append("idutilizacaoproduto=?,");
            sql.append("codigobarras=?,");
            sql.append("descricaoproduto=?,");
            sql.append("descricaopdv=?,");
            sql.append("controlarestoque=?,");
            sql.append("percsobrepreco=?,");
            sql.append("emitiretiquetagondola=?,");
            sql.append("peso=?,");
            sql.append("validade=?,");
            sql.append("altura=?,");
            sql.append("largura=?,");
            sql.append("profundidade=?,");
            sql.append("idusuarioinclusao=?,");
            sql.append("datahorainclusao=?,");
            sql.append("idusuarioaprovacaocad=?,");
            sql.append("idusuarioaprovacaocomercial=?,");
            sql.append("idusuarioaprovacaofiscalcontabil=?,");
            sql.append("datahoraaprovacaocad=?,");
            sql.append("datahoraaprovacaocomercial=?,");
            sql.append("datahoraaprovacaofiscalcontabil=?,");
            sql.append("etiquetacomfragrancia=?,");
            sql.append("fragranciacaracteristica=?,");
            sql.append("descricaoprodutoagricola=?,");
            sql.append("idprincipalmaster=?,");
            sql.append("idclassificacaofiscal=?,");
            sql.append("emitiretiquetabalanca=?,");
            sql.append("descricaoetiquetabalanca=?,");
            sql.append("numeroetiquetasimpressao=?,");
            sql.append("idunidadepeso=?,");
            sql.append("descricaoetiquetagondolasemfragrancia=?,");
            sql.append("descricaoetiquetagondolacomfragrancia1=?,");
            sql.append("descricaoetiquetagondolacomfragrancia2=?,");
            sql.append("idsetorbalanca=?,");
            sql.append("caracteristica=?,");
            sql.append("idgrupomaterialconsumo=?,");
            sql.append("descricaoembalagem=?,");
            sql.append("precovendavarejo=?,");
            sql.append("idtipoitem=?,");
            sql.append("idunidadeinventario=?,");
            sql.append("aliquotaipi=?,");
            sql.append("exigeaprovacaopedido=?,");
            sql.append("iddiretor=?,");
            sql.append("idtiporateiodefault=?,");
            sql.append("exigepedido=?,");
            sql.append("descontinuado=?,");
            sql.append("atualizacaoprecosautomatica=?,");
            sql.append("comercializadorestaurante=?,");
            sql.append("idprodutorevenda=?,");
            sql.append("parametrizacaofiscalalterada=?,");
            sql.append("datahoraparametrizacaofiscalalterada=?,");
            sql.append("idusuarioaprovacaoalteracaocadastro=?,");
            sql.append("datahoraaprovacaoalteracaocadastro=?,");
            sql.append("tipopedido=?,");
            sql.append("idtipolocalcompra=?,");
            sql.append("idcodigonaturezareceita=?,");
            sql.append("pesopedido=?,");
            sql.append("idunidadepesopedido=?,");
            sql.append("idtipoprodutoinsumoproducaointerna=?,");
            sql.append("idunidademedidaconsumoproducaointerna=?,");
            sql.append("quantidadeembalagemcomprainsumo=?,");
            sql.append("codigounico=?,");
            sql.append("idcorfundotransferenciacodigorgb=?,");
            sql.append("descricaocomercial=?,");
            sql.append("quantidadeinfnutri=?,");
            sql.append("idunidadeporcaoinfnutri=?,");
            sql.append("parteinteirainfnutri=?,");
            sql.append("idpartedecimalinfnutri=?,");
            sql.append("idmedidacaseirainfnutri=?,");
            sql.append("valorenergeticoinfnutri=?,");
            sql.append("carboidratosinfnutri=?,");
            sql.append("proteinasinfnutri=?,");
            sql.append("gordurastotaisinfnutri=?,");
            sql.append("gordurassaturadasinfnutri=?,");
            sql.append("gordurastransinfnutri=?,");
            sql.append("fibraalimentarinfnutri=?,");
            sql.append("sodioinfnutri=?");
            sql.append(" where id = ? ");
            pstUpdate = con.prepareStatement(sql.toString());

            final int batchSize = 1000;
            int count = 0;

            for (produto obj : listaproduto) {
                if (obj.getid() == 0) {

                    pstInsert.setInt(1, obj.getiddescricaoproduto());
                    pstInsert.setInt(2, obj.getidsubcodigoproduto());
                    pstInsert.setInt(3, obj.getidmarcaproduto());
                    pstInsert.setInt(4, obj.getidsituacaoproduto());
                    pstInsert.setInt(5, obj.getidsetorproduto());
                    pstInsert.setInt(6, obj.getidtipoproduto());
                    pstInsert.setInt(7, obj.getidgrupoproduto());
                    pstInsert.setInt(8, obj.getidsubgrupoproduto());
                    pstInsert.setInt(9, obj.getidclasseproduto());
                    pstInsert.setInt(10, obj.getidunidadeproduto());
                    pstInsert.setInt(11, obj.getidutilizacaoproduto());
                    pstInsert.setString(12, obj.getcodigobarras());
                    pstInsert.setString(13, obj.getdescricaoproduto());
                    pstInsert.setString(14, obj.getdescricaopdv());
                    pstInsert.setString(15, obj.getcontrolarestoque());
                    pstInsert.setBigDecimal(16, obj.getpercsobrepreco());
                    pstInsert.setString(17, obj.getemitiretiquetagondola());
                    pstInsert.setBigDecimal(18, obj.getpeso());
                    pstInsert.setInt(19, obj.getvalidade());
                    pstInsert.setBigDecimal(20, obj.getaltura());
                    pstInsert.setBigDecimal(21, obj.getlargura());
                    pstInsert.setBigDecimal(22, obj.getprofundidade());
                    pstInsert.setInt(23, obj.getidusuarioinclusao());
                    pstInsert.setString(24, obj.getdatahorainclusao());
                    pstInsert.setInt(25, obj.getidusuarioaprovacaocad());
                    pstInsert.setInt(26, obj.getidusuarioaprovacaocomercial());
                    pstInsert.setInt(27, obj.getidusuarioaprovacaofiscalcontabil());
                    pstInsert.setString(28, obj.getdatahoraaprovacaocad());
                    pstInsert.setString(29, obj.getdatahoraaprovacaocomercial());
                    pstInsert.setString(30, obj.getdatahoraaprovacaofiscalcontabil());
                    pstInsert.setString(31, obj.getetiquetacomfragrancia());
                    pstInsert.setString(32, obj.getfragranciacaracteristica());
                    pstInsert.setString(33, obj.getdescricaoprodutoagricola());
                    pstInsert.setInt(34, obj.getidprincipalmaster());
                    pstInsert.setInt(35, obj.getidclassificacaofiscal());
                    pstInsert.setString(36, obj.getemitiretiquetabalanca());
                    pstInsert.setString(37, obj.getdescricaoetiquetabalanca());
                    pstInsert.setInt(38, obj.getnumeroetiquetasimpressao());
                    pstInsert.setInt(39, obj.getidunidadepeso());
                    pstInsert.setString(40, obj.getdescricaoetiquetagondolasemfragrancia());
                    pstInsert.setString(41, obj.getdescricaoetiquetagondolacomfragrancia1());
                    pstInsert.setString(42, obj.getdescricaoetiquetagondolacomfragrancia2());
                    pstInsert.setInt(43, obj.getidsetorbalanca());
                    pstInsert.setString(44, obj.getcaracteristica());
                    pstInsert.setInt(45, obj.getidgrupomaterialconsumo());
                    pstInsert.setString(46, obj.getdescricaoembalagem());
                    pstInsert.setBigDecimal(47, obj.getprecovendavarejo());
                    pstInsert.setInt(48, obj.getidtipoitem());
                    pstInsert.setInt(49, obj.getidunidadeinventario());
                    pstInsert.setBigDecimal(50, obj.getaliquotaipi());
                    pstInsert.setString(51, obj.getexigeaprovacaopedido());
                    pstInsert.setInt(52, obj.getiddiretor());
                    pstInsert.setInt(53, obj.getidtiporateiodefault());
                    pstInsert.setString(54, obj.getexigepedido());
                    pstInsert.setString(55, obj.getdescontinuado());
                    pstInsert.setString(56, obj.getatualizacaoprecosautomatica());
                    pstInsert.setString(57, obj.getcomercializadorestaurante());
                    pstInsert.setInt(58, obj.getidprodutorevenda());
                    pstInsert.setString(59, obj.getparametrizacaofiscalalterada());
                    pstInsert.setString(60, obj.getdatahoraparametrizacaofiscalalterada());
                    pstInsert.setInt(61, obj.getidusuarioaprovacaoalteracaocadastro());
                    pstInsert.setString(62, obj.getdatahoraaprovacaoalteracaocadastro());
                    pstInsert.setString(63, obj.gettipopedido());
                    pstInsert.setInt(64, obj.getidtipolocalcompra());
                    pstInsert.setInt(65, obj.getidcodigonaturezareceita());
                    pstInsert.setBigDecimal(66, obj.getpesopedido());
                    pstInsert.setInt(67, obj.getidunidadepesopedido());
                    pstInsert.setInt(68, obj.getidtipoprodutoinsumoproducaointerna());
                    pstInsert.setInt(69, obj.getidunidademedidaconsumoproducaointerna());
                    pstInsert.setBigDecimal(70, obj.getquantidadeembalagemcomprainsumo());
                    pstInsert.setString(71, obj.getcodigounico());
                    pstInsert.setInt(72, obj.getidcorfundotransferenciacodigorgb());
                    pstInsert.setString(73, obj.getdescricaocomercial());
                    pstInsert.setInt(74, obj.getquantidadeinfnutri());
                    pstInsert.setInt(75, obj.getidunidadeporcaoinfnutri());
                    pstInsert.setInt(76, obj.getparteinteirainfnutri());
                    pstInsert.setInt(77, obj.getidpartedecimalinfnutri());
                    pstInsert.setInt(78, obj.getidmedidacaseirainfnutri());
                    pstInsert.setInt(79, obj.getvalorenergeticoinfnutri());
                    pstInsert.setBigDecimal(80, obj.getcarboidratosinfnutri());
                    pstInsert.setBigDecimal(81, obj.getproteinasinfnutri());
                    pstInsert.setBigDecimal(82, obj.getgordurastotaisinfnutri());
                    pstInsert.setBigDecimal(83, obj.getgordurassaturadasinfnutri());
                    pstInsert.setBigDecimal(84, obj.getgordurastransinfnutri());
                    pstInsert.setBigDecimal(85, obj.getfibraalimentarinfnutri());
                    pstInsert.setBigDecimal(86, obj.getsodioinfnutri());
                    pstInsert.addBatch();
                    if (++count % batchSize == 0) {
                        pstInsert.executeBatch();
                    }

                } else {

                    pstUpdate.setInt(1, obj.getiddescricaoproduto());
                    pstUpdate.setInt(2, obj.getidsubcodigoproduto());
                    pstUpdate.setInt(3, obj.getidmarcaproduto());
                    pstUpdate.setInt(4, obj.getidsituacaoproduto());
                    pstUpdate.setInt(5, obj.getidsetorproduto());
                    pstUpdate.setInt(6, obj.getidtipoproduto());
                    pstUpdate.setInt(7, obj.getidgrupoproduto());
                    pstUpdate.setInt(8, obj.getidsubgrupoproduto());
                    pstUpdate.setInt(9, obj.getidclasseproduto());
                    pstUpdate.setInt(10, obj.getidunidadeproduto());
                    pstUpdate.setInt(11, obj.getidutilizacaoproduto());
                    pstUpdate.setString(12, obj.getcodigobarras());
                    pstUpdate.setString(13, obj.getdescricaoproduto());
                    pstUpdate.setString(14, obj.getdescricaopdv());
                    pstUpdate.setString(15, obj.getcontrolarestoque());
                    pstUpdate.setBigDecimal(16, obj.getpercsobrepreco());
                    pstUpdate.setString(17, obj.getemitiretiquetagondola());
                    pstUpdate.setBigDecimal(18, obj.getpeso());
                    pstUpdate.setInt(19, obj.getvalidade());
                    pstUpdate.setBigDecimal(20, obj.getaltura());
                    pstUpdate.setBigDecimal(21, obj.getlargura());
                    pstUpdate.setBigDecimal(22, obj.getprofundidade());
                    pstUpdate.setInt(23, obj.getidusuarioinclusao());
                    pstUpdate.setString(24, obj.getdatahorainclusao());
                    pstUpdate.setInt(25, obj.getidusuarioaprovacaocad());
                    pstUpdate.setInt(26, obj.getidusuarioaprovacaocomercial());
                    pstUpdate.setInt(27, obj.getidusuarioaprovacaofiscalcontabil());
                    pstUpdate.setString(28, obj.getdatahoraaprovacaocad());
                    pstUpdate.setString(29, obj.getdatahoraaprovacaocomercial());
                    pstUpdate.setString(30, obj.getdatahoraaprovacaofiscalcontabil());
                    pstUpdate.setString(31, obj.getetiquetacomfragrancia());
                    pstUpdate.setString(32, obj.getfragranciacaracteristica());
                    pstUpdate.setString(33, obj.getdescricaoprodutoagricola());
                    pstUpdate.setInt(34, obj.getidprincipalmaster());
                    pstUpdate.setInt(35, obj.getidclassificacaofiscal());
                    pstUpdate.setString(36, obj.getemitiretiquetabalanca());
                    pstUpdate.setString(37, obj.getdescricaoetiquetabalanca());
                    pstUpdate.setInt(38, obj.getnumeroetiquetasimpressao());
                    pstUpdate.setInt(39, obj.getidunidadepeso());
                    pstUpdate.setString(40, obj.getdescricaoetiquetagondolasemfragrancia());
                    pstUpdate.setString(41, obj.getdescricaoetiquetagondolacomfragrancia1());
                    pstUpdate.setString(42, obj.getdescricaoetiquetagondolacomfragrancia2());
                    pstUpdate.setInt(43, obj.getidsetorbalanca());
                    pstUpdate.setString(44, obj.getcaracteristica());
                    pstUpdate.setInt(45, obj.getidgrupomaterialconsumo());
                    pstUpdate.setString(46, obj.getdescricaoembalagem());
                    pstUpdate.setBigDecimal(47, obj.getprecovendavarejo());
                    pstUpdate.setInt(48, obj.getidtipoitem());
                    pstUpdate.setInt(49, obj.getidunidadeinventario());
                    pstUpdate.setBigDecimal(50, obj.getaliquotaipi());
                    pstUpdate.setString(51, obj.getexigeaprovacaopedido());
                    pstUpdate.setInt(52, obj.getiddiretor());
                    pstUpdate.setInt(53, obj.getidtiporateiodefault());
                    pstUpdate.setString(54, obj.getexigepedido());
                    pstUpdate.setString(55, obj.getdescontinuado());
                    pstUpdate.setString(56, obj.getatualizacaoprecosautomatica());
                    pstUpdate.setString(57, obj.getcomercializadorestaurante());
                    pstUpdate.setInt(58, obj.getidprodutorevenda());
                    pstUpdate.setString(59, obj.getparametrizacaofiscalalterada());
                    pstUpdate.setString(60, obj.getdatahoraparametrizacaofiscalalterada());
                    pstUpdate.setInt(61, obj.getidusuarioaprovacaoalteracaocadastro());
                    pstUpdate.setString(62, obj.getdatahoraaprovacaoalteracaocadastro());
                    pstUpdate.setString(63, obj.gettipopedido());
                    pstUpdate.setInt(64, obj.getidtipolocalcompra());
                    pstUpdate.setInt(65, obj.getidcodigonaturezareceita());
                    pstUpdate.setBigDecimal(66, obj.getpesopedido());
                    pstUpdate.setInt(67, obj.getidunidadepesopedido());
                    pstUpdate.setInt(68, obj.getidtipoprodutoinsumoproducaointerna());
                    pstUpdate.setInt(69, obj.getidunidademedidaconsumoproducaointerna());
                    pstUpdate.setBigDecimal(70, obj.getquantidadeembalagemcomprainsumo());
                    pstUpdate.setString(71, obj.getcodigounico());
                    pstUpdate.setInt(72, obj.getidcorfundotransferenciacodigorgb());
                    pstUpdate.setString(73, obj.getdescricaocomercial());
                    pstUpdate.setInt(74, obj.getquantidadeinfnutri());
                    pstUpdate.setInt(75, obj.getidunidadeporcaoinfnutri());
                    pstUpdate.setInt(76, obj.getparteinteirainfnutri());
                    pstUpdate.setInt(77, obj.getidpartedecimalinfnutri());
                    pstUpdate.setInt(78, obj.getidmedidacaseirainfnutri());
                    pstUpdate.setInt(79, obj.getvalorenergeticoinfnutri());
                    pstUpdate.setBigDecimal(80, obj.getcarboidratosinfnutri());
                    pstUpdate.setBigDecimal(81, obj.getproteinasinfnutri());
                    pstUpdate.setBigDecimal(82, obj.getgordurastotaisinfnutri());
                    pstUpdate.setBigDecimal(83, obj.getgordurassaturadasinfnutri());
                    pstUpdate.setBigDecimal(84, obj.getgordurastransinfnutri());
                    pstUpdate.setBigDecimal(85, obj.getfibraalimentarinfnutri());
                    pstUpdate.setBigDecimal(86, obj.getsodioinfnutri());
                    pstUpdate.setInt(87, obj.getid());
                    pstUpdate.addBatch();
                    if (++count % batchSize == 0) {
                        pstUpdate.executeBatch();
                    }
                }
            }

            if (pstInsert != null) {
                pstInsert.executeBatch();
            }

            if (pstUpdate != null) {
                pstUpdate.executeBatch();
            }

        } catch (Exception ex) {
            throw new Exception(ex.getMessage() + "\n" + this.getClass().getName() + ".salvarproduto()");
        } finally {
            freeResources(null, pstUpdate, null);
            freeResources(null, pstInsert, con);
        }
    }

    private void freeResources(Object object, PreparedStatement pstUpdate, Object object0) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Connection conectaBDerp() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
