package universidadean.mundial.interfaz;

import ean.collections.IList;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import universidadean.mundial.mundo.Equipo;
import universidadean.mundial.mundo.Jugador;
import universidadean.mundial.mundo.Mundial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Funciones y métodos de utilidad dentro de esta clase
 */
public class Utils {
    public static <T> T[] toArray(IList<T> lista) {
        ArrayList<T> elementos = new ArrayList<>();
        for (T elem : lista) {
            elementos.add(elem);
        }
        return (T[]) elementos.toArray();
    }

    /**
     * Método que obtiene la información de los datos de los equipos a partir
     * del archivo que contiene estos datos.
     * @param mundial el objeto donde se almacenarán los datos
     * @throws Exception si se produce cualquier error
     */
    public static void leerMundial(Mundial mundial) throws Exception {
        FileReader input = new FileReader("./data/mundial.equipos");
        JSONParser parser = new JSONParser();
        JSONArray equipos = (JSONArray) parser.parse(input);

        for (Object equipo : equipos) {
            guardarEquipo(mundial, (JSONObject) equipo);
        }

        input.close();
    }

    /**
     * Permite almacenar los datos de un equipo en el mundial
     * @param mundial el objeto que almacena los equipos
     * @param equipo el equipo que queremos almacenar
     */
    private static void guardarEquipo(Mundial mundial, JSONObject equipo) throws Exception{
        String pais = (String) equipo.get("pais");
        String director = (String) equipo.get("director");
        String imagen = (String) equipo.get("imagen");

        mundial.agregarEquipo(pais, director, imagen);
        Equipo e = mundial.darEquipo(pais);
        JSONArray jugadores = (JSONArray) equipo.get("jugadores");
        leerJugadores(e, jugadores);
    }

    private static Jugador leerJugador(JSONObject jsonJugador) {
        String nombre = (String) jsonJugador.get("nombre");
        long edad = (Long) jsonJugador.get("edad");
        String posicion = (String) jsonJugador.get("posicion");
        double altura = (Double) jsonJugador.get("altura");
        double peso = (Double) jsonJugador.get("peso");
        double salario = (Double) jsonJugador.get("salario");
        String imagen = (String) jsonJugador.get("imagen");

        return new Jugador(nombre, (int) edad, posicion, altura, peso, salario, imagen);
    }

    private static void leerJugadores(Equipo equipo, JSONArray jugadores) {
        for (Object jsonObject : jugadores) {
            JSONObject jsonJugador = (JSONObject) jsonObject;
            Jugador jugador = leerJugador(jsonJugador);
            equipo.agregarJugador(jugador);
        }
    }

    /**
     * Permite agregar los datos del jugador dado al vector jugadores
     * @param jugadores el vector donde guardaremos el jugador
     * @param jugador el jugador a guardar
     */
    private static void escribirJugador(JSONArray jugadores, Jugador jugador) {
        JSONObject j = new JSONObject();
        j.put("nombre", jugador.getNombre());
        j.put("edad", jugador.getEdad());
        j.put("posicion", jugador.getPosicion());
        j.put("altura", jugador.getAltura());
        j.put("peso", jugador.getPeso());
        j.put("salario", jugador.getSalario());
        j.put("imagen", jugador.getImagen());

        jugadores.add(j);
    }

    private static JSONArray escribirJugadores(Equipo equipo) {
        JSONArray jugadores = new JSONArray();

        for (String nomJugador : equipo.darNombresJugadores()) {
            Jugador jugador = equipo.darJugador(nomJugador);
            escribirJugador(jugadores, jugador);
        }

        return jugadores;
    }

    private static @NotNull JSONObject escribirEquipo(@NotNull Equipo equipo) {
        JSONObject obj = new JSONObject();

        obj.put("pais", equipo.getPais());
        obj.put("director", equipo.getDirector());
        obj.put("imagen", equipo.getImagen());
        obj.put("jugadores", escribirJugadores(equipo));

        return obj;
    }

    public static void guardarMundial(@NotNull Mundial mundial) throws Exception {
        JSONArray equipos = new JSONArray();

        for (String nomEquipo : mundial.darNombresEquipos()) {
            Equipo equipo = mundial.darEquipo(nomEquipo);
            equipos.add(escribirEquipo(equipo));
        }

        FileWriter file = new FileWriter("./data/mundial.equipos");
        file.write(equipos.toJSONString());
        file.flush();
        file.close();
    }
}
