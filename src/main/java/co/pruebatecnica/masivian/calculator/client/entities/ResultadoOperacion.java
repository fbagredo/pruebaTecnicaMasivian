package co.pruebatecnica.masivian.calculator.client.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
	public class ResultadoOperacion {
		@Id
		@GeneratedValue
		private Long id;
		private int intA;
		private int intB;
		private String operacion;
		private int resultado;
		
		ResultadoOperacion(){
			super();
		}
		
		public ResultadoOperacion(int intA, int intB, String operacion, int resultado) {
			super();
			this.intA = intA;
			this.intB = intB;
			this.operacion = operacion;
			this.resultado = resultado;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getIntA() {
			return intA;
		}
		public void setIntA(int intA) {
			this.intA = intA;
		}
		public int getIntB() {
			return intB;
		}
		public void setIntB(int intB) {
			this.intB = intB;
		}
		public String getOperacion() {
			return operacion;
		}
		public void setOperacion(String operacion) {
			this.operacion = operacion;
		}
		public int getResultado() {
			return resultado;
		}
		public void setResultado(int resultado) {
			this.resultado = resultado;
		}

		@Override
		public String toString() {
			return "ResultadoOperacion [id=" + id + ", intA=" + intA + ", intB=" + intB + ", operacion=" + operacion
					+ ", resultado=" + resultado + "]";
		}
}

