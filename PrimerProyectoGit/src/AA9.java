import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

interface calcular
{
	int montoTotal();
	int recaudacionTotal();
}

class Videojuego implements calcular
{
	private String nombre;
	private int ventas;
	private int precio;
	
	public static List<Videojuego> lista = new ArrayList<Videojuego>();
	
	public Videojuego(String nombre, int ventas, int precio) {
		super();
		this.nombre = nombre;
		this.ventas = ventas;
		this.precio = precio;
		lista.add(this);
	}
	
	@Override
	public String toString() {
		return nombre + "			" + ventas + "				" + precio + "€";
	}

	@Override
	public int montoTotal() {
		int sum = 0;
		for (Videojuego v : Videojuego.lista) {
			sum+=v.ventas;
		}
		return sum;
	}

	@Override
	public int recaudacionTotal() {
		int sum = 0;
		for (Videojuego v : Videojuego.lista) {
			sum+=v.ventas*v.precio;
		}
		return sum;
	}
}

public class AA9 
{
	
	public static void main (String [] args)
	{
		Videojuego videojuego = new Videojuego("DARK SOULS 3", 10000, 5);
		videojuego = new Videojuego("THE LAST OF US", 50000, 10);
		videojuego = new Videojuego("FIFA 2022", 60000, 15);
		videojuego = new Videojuego("MARIO BROSS", 45000, 1);
		videojuego = new Videojuego("DOOM 2	", 100000, 1);
		videojuego = new Videojuego("HORIZON	", 50000, 5);
		List<String> lineas = new ArrayList<>();
		lineas.add("VIDEOJUEGOS:			CANTIDAD DE REGISTROS		PRECIO UNITARIO");
		for (Videojuego v : Videojuego.lista) {
			lineas.add(v.toString());
		}
		lineas.add("\n");
		lineas.add("Monto total: 			" + videojuego.montoTotal());
		lineas.add("Recaudación total: 		" + videojuego.recaudacionTotal() + "€");
		try
		{
			String nombreArchivo = "videojuegos.txt";
			Path file = Paths.get(nombreArchivo);
			Files.write(file, lineas, StandardCharsets.UTF_8);
		}
		catch (IOException e)
		{
			System.out.println("Ocurrió un error");
			e.printStackTrace();
		}
		for (String linea : lineas) {
			System.out.println(linea);
		}
	}
	
}
