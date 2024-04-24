package br.com.fintech.enums;

public enum TipoInvestimento {
	CDBS(23),
	TESOURODIRETOSELIC(21);
	
	private int cd_tipo_investimento;
	TipoInvestimento(int cd_tipo_investimento) {
        this.cd_tipo_investimento = cd_tipo_investimento;
	}
	
   public int getCdTipoInvestimento() {
        return this.cd_tipo_investimento;
    }

}
