package com.pb.apitst.domain.endereco;

public enum TipoUF {
        AC("Acre"),
        AL("Alagoas"),
        AP("Amapá"),
        AM("Amazonas"),
        BA("Bahia"),
        CE("Ceará"),
        DF("Distrito Federal"),
        ES("Espírito Santo"),
        GO("Goiás"),
        MA("Maranhão"),
        MT("Mato Grosso"),
        MS("Mato Grosso do Sul"),
        MG("Minhas Gerais"),
        PA("Pará"),
        PB("Paraíba"),
        PR("Paraná"),
        PE("Pernambuco"),
        PI("Piauí"),
        RJ("Rio de Janeiro"),
        RN("Rio Grande do Norte"),
        RS("Rio Grande do Sul"),
        RO("Rondônia"),
        RR("Roraima"),
        SC("Santa Catarina"),
        SP("São Paulo"),
        SE("Sergipe"),
        TO("Tocantins");

        private final String estadoUF;

        // Construtor do Enum
        TipoUF(String estadoUF) {
            this.estadoUF = estadoUF;
        }
// TODO
        // Método para obter o nome completo da unidade federativa
        public String getEstadoUF() {
            return estadoUF;
        }
// TODO
        // Método para buscar uma UnidadeFederativa pela sigla
        public static TipoUF fromSigla(String sigla) {
            for (TipoUF uf : TipoUF.values()) {
                if (uf.name().equalsIgnoreCase(sigla)) {
                    return uf;
                }
            }
            throw new IllegalArgumentException("Sigla de UF inválida: " + sigla);
        }

        @Override
        public String toString() {
            return this.estadoUF;
        }
}
