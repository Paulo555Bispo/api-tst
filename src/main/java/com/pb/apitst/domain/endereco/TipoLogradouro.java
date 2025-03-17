package com.pb.apitst.domain.endereco;

public enum TipoLogradouro {
    ACESSO("Acesso"),
    AEROPORTO("Aeroporto"),
    ALAMEDA("Alameda"),
    AREA("Área"),
    AVENIDA("Avenida"),
    BECO("Beco"),
    BLOCO("Bloco"),
    BOSQUE("Bosque"),
    CAMINHO("Caminho"),
    CAMPO("Campo"),
    CHACARA("Chácara"),
    COLONIA("Colônia"),
    CONDOMINIO("Condomínio"),
    CONJUNTO("Conjunto"),
    DISTRITO("Distrito"),
    ESPLANADA("Esplanada"),
    ESTACAO("Estação"),
    ESTRADA("Estrada"),
    FAVELA("Favela"),
    FAZENDA("Fazenda"),
    FLORESTA("Floresta"),
    FONTE("Fonte"),
    FORTALEZA("Fortaleza"),
    GALERIA("Galeria"),
    GRANJA("Granja"),
    ILHA("Ilha"),
    JARDIM("Jardim"),
    LADEIRA("Ladeira"),
    LAGO("Lago"),
    LAGOA("Lagoa"),
    LARGO("Largo"),
    LOTEAMENTO("Loteamento"),
    MERCADO("Mercado"),
    MORRO("Morro"),
    NUCLEO("Núcleo"),
    PARQUE("Parque"),
    PASSAGEM("Passagem"),
    PATIO("Pátio"),
    PRACA("Praça"),
    PRAIA("Praia"),
    QUADRA("Quadra"),
    RECANTO("Recanto"),
    RESIDENCIAL("Residencial"),
    RODOVIA("Rodovia"),
    RUA("Rua"),
    SERVIDAO("Servidão"),
    SETOR("Setor"),
    SITIO("Sítio"),
    TRAVESSA("Travessa"),
    TREVO("Trevo"),
    VALE("Vale"),
    VEREDA("Vereda"),
    VIA("Via"),
    VIADUTO("Viaduto"),
    VIELA("Viela"),
    VILA("Vila");

    private String descricao;

    TipoLogradouro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
