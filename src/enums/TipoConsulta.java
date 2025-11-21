package enums;

public enum TipoConsulta {
    CONSULTA_VETERINARIA("Consulta normal."),
    VACINACAO("Vacinação de rotina."),
    EMERGENCIA("Atendimento de emergência."),
    RETORNO("Retorno de consulta. "),
    CIRURGIA("Cirurgia agendada.");

    private String descricao;

    private TipoConsulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
