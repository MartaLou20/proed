package personas;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sheila R.
 */
public class Paciente extends Persona{
    protected String idHistorial;
    protected Medico medico;
    protected String codigo;
    protected String estado; //estable,grave o pendiente traslado
    protected int prioridad;
    protected float tensionArterial;
    protected int saturacion;
    protected int frecuenciaCardiaca;
    protected int frecuenciaRespiratoria;
    protected float temperatura;
    Scanner sc = new Scanner(System.in);
    
    public Paciente(String dni, String nombre, String apellido, LocalDate fechaNacimiento) {
        super(dni, nombre, apellido, fechaNacimiento);
    }
    
    /**
     * Este m�todo a�ade las constantes vitales iniciales del paciente
     * de manera aleatoria.
     * Los l�mites de la generaci�n est�n seleccionados de manera que los valores
     * recibidos sean posibles en una persona viva.
     * 
     */
    public void addConstantes(){
        Random rd = new Random();
        
        tensionArterial = rd.nextFloat(6.4f, 20.15f);
        saturacion = rd.nextInt(85, 100);
        frecuenciaCardiaca = rd.nextInt(30, 200);
        frecuenciaRespiratoria = rd.nextInt(5, 50);
        temperatura = rd.nextFloat(33, 45);
        
        System.out.println("Constantes vitales a�adidas.");
    }
    
    /**
     * Este m�todo permite modificar las constantes vitales del paciente de manera individual.
     * Simula la monitorizaci�n de las constantes del paciente con las diferentes 
     * herramientas empleadas para esta tarea una vez est� bajo vigilancia.
     */
    public void modificarConstantes(){//lo haremos manual pero se obtedria por medio  de la monitorizacion 
        String constante;
        System.out.println("Seleccione la constante que quiere modificar:");
        System.out.println("'ta' para tensi�n, 'so' para saturaci�n, 'fc' para frecuencia cardiaca, 'fr' para frecuencia respiratoria, 'temp' para temperatura");
        constante = sc.nextLine();
        while(!"ta".equalsIgnoreCase(constante) && !"so".equalsIgnoreCase(constante) && !"fc".equalsIgnoreCase(constante) && !"fr".equalsIgnoreCase(constante) && !"temp".equalsIgnoreCase(constante)){
            System.out.println("Error. Introduzca una de las opciones v�lidas ('ta', 'so', 'fc', 'fr' o 'temp'): ");
            constante = sc.nextLine();
        }
        switch(constante){
            case "ta":
                System.out.println("Introduce la tensi�n arterial actual del paciente: ");
                while (!sc.hasNextFloat()){
                    System.out.println("Error, introduzca un valor decimal");
                    sc.next();
                }
                tensionArterial = sc.nextFloat();
                System.out.println("Tensi�n arterial actualizada.");
                break;
            case "so":
                System.out.println("Introduce la saturaci�n de ox�geno en sangre actual del paciente: ");
                while (!sc.hasNextInt()){
                    System.out.println("Error, introduzca un valor entero");
                    sc.next();
                }
                saturacion = sc.nextInt();
                System.out.println("Saturaci�n de ox�geno en sangre actualizada.");
                break;
            case "fc":
                System.out.println("Introduce la frecuencia cardiaca actual del paciente: ");
                while (!sc.hasNextInt()){
                    System.out.println("Error, introduzca un valor entero");
                }
                frecuenciaCardiaca = sc.nextInt();
                System.out.println("Frecuencia cardiaca actualizada.");
                break;
            case "fr":
                System.out.println("Introduce la frecuencia respiratoria actual del paciente: ");
                while (!sc.hasNextInt()){
                    System.out.println("Error, introduzca un valor entero");
                }
                frecuenciaRespiratoria = sc.nextInt();
                System.out.println("Frecuencia respiratoria actualizada.");
                break;
            case "temp":
                System.out.println("Introduce la temperatura actual del paciente: ");
                while (!sc.hasNextFloat()){
                    System.out.println("Error, introduzca un valor entero");
                }
                temperatura = sc.nextFloat();
                System.out.println("Temperatura actualizada.");
                break;
        }
    }
    
    /**
     * Este m�todo permite asignar un estado al paciente, cuyo valor puede ser
     * estable, grave o pendiente de traslado a otra unidad.
     * 
     * @return devuelve el estado del paciente asignado
     */
    public String actualizarEstadoPaciente(){
        System.out.println("Indique el estado actual del paciente:");
        estado = sc.nextLine();
        while(!"estable".equalsIgnoreCase(estado) && !"grave".equalsIgnoreCase(estado) && !"pendiente".equalsIgnoreCase(estado)){
            System.out.println("Error. Introduzca una de las opciones v�lidas ('estable', 'grave' o 'pendiente'(para pte. de traslado)): ");
            estado = sc.nextLine();
        }
        return estado;
    }
    
    public void mostrarConstantes() {
        System.out.println("=== Constantes Vitales de " + nombre + " " + apellido + " ===");
        System.out.println("Frecuencia Card�aca: " + frecuenciaCardiaca + " bpm");
        System.out.println("Presi�n Arterial: " + tensionArterial + " mmHg");
        System.out.println("Frecuencia Respiratoria: " + frecuenciaRespiratoria + " rpm");
        System.out.println("Temperatura: " + temperatura + " �C");
        System.out.println("Saturaci�n de Ox�geno: " + saturacion + " %");
        System.out.println("=========================================");
    }
    
    public void mostrarEstadoPaciente(){
        System.out.println("=== Estado actual de " + nombre + " " + apellido + " ===");
        
        if (estado == null){
            System.out.println("El estado de este paciente no est� actualizado.");
        } else if(estado.equalsIgnoreCase("estable")){
            System.out.println(estado);
            System.out.println("El paciente est� estable. Ser� necesario volver a comprobar su estado.");
        } else if(estado.equalsIgnoreCase("grave")){
            System.out.println(estado);
            System.out.println("El paciente est� bajo vigilancia dada la gravedad de su caso.");
        }else if(estado.equalsIgnoreCase("pendiente")){
            System.out.println(estado);
            System.out.println("El paciente est� pendiente de traslado a otra unidad. "
                    + "Para comprobar el estado de la solicitud de traslado, contacte con la unidad correspondiente.");
        }   
        System.out.println("=========================================");
        
    }
}
