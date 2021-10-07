package parcial1.pb2.tm.dominio;

public class Corredor extends Socio {
	private DistanciaPreferida distanciaPreferida;

	public Corredor(Integer nroSocio, String nombre, String apellido, DistanciaPreferida distanciaPreferida) {
		super(nroSocio, nombre, apellido);
		this.distanciaPreferida=distanciaPreferida;
		setTipoDeDeportista(TipoDeDeportista.CORREDOR);
	}

	public DistanciaPreferida getTipoDeBicicleta() {
		return distanciaPreferida;
	}

	public void setTipoDeBicicleta(DistanciaPreferida distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

}
