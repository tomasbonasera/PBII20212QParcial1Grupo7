package parcial1pb2.dominio;

public class Corredor extends Socio {
	private DistanciaPreferida distanciaPreferida;

	public Corredor(Integer nroSocio, String nombre, String apellido, DistanciaPreferida distanciaPreferida) {
		super(nroSocio, nombre, apellido);
		this.distanciaPreferida=distanciaPreferida;
		setTipoDeDeportista(TipoDeDeportista.CORREDOR);
	}

	public DistanciaPreferida getDistanciaPreferida() {
		return distanciaPreferida;
	}

	public void setDistanciaPreferida(DistanciaPreferida distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

}