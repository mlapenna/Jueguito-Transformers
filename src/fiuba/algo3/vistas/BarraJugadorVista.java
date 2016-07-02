package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Casillero;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.vistas.AlgoformerVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.ArrayList;
import javafx.concurrent.Task;

public class BarraJugadorVista {
	
	Jugador jugador;
	
	public BarraJugadorVista(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public VBox getAlgoformersContenedor() {
		
		VBox contenedorAlgoformers = new VBox();
		ArrayList<Algoformer> algoformers = this.jugador.getAlgoformers();
		Algoformer algoformer;
		Text nombre = new Text(this.jugador.nombre());
		contenedorAlgoformers.getChildren().add(nombre);
		for(int i=0;i<algoformers.size();i++) {
			
			algoformer = algoformers.get(i);

			HBox contenedorVida = crearContenedor("Vida",algoformer.getModo().getVida(),algoformer.getVida());
			HBox contenedorAtaque = crearContenedor("Ataque",algoformer.getModo().getAtaqueInicial(),algoformer.getAtaque());
			HBox contenedorVelocidad = crearContenedor("Velocidad",algoformer.getModo().getVelocidad(),algoformer.getVelocidad());
			HBox contenedorDistancia = crearContenedor("Distancia de ataque",algoformer.getModo().getDistanciaAtaque(),algoformer.getDistanciaAtaque());
			
			VBox contenedorAtributos = new VBox(contenedorVida,contenedorAtaque,contenedorVelocidad,contenedorDistancia);
			contenedorAtributos.setPadding(new Insets(15));
			HBox contenedorRobot = new HBox(this.getAlgoformerVista(algoformer),contenedorAtributos);
		
			contenedorAlgoformers.getChildren().add(contenedorRobot);
		}		
		
		return contenedorAlgoformers;
	}

	private AlgoformerVista getAlgoformerVista(Algoformer algoformer) {
		Casillero casillero = new Casillero(new Posicion(0,0));
		casillero.setContenido(algoformer);
		return new AlgoformerVista(casillero);
	}
	
	private HBox crearContenedor(String atributo,Integer valorOriginal,float valorActual) {

		Text label = new Text(atributo+" ( "+valorActual+" )");
		ProgressBar pb = new ProgressBar(1.2f);
		pb.setProgress((float)valorActual/valorOriginal);
		
		HBox contenedorAtributo = new HBox();
		contenedorAtributo.setSpacing(10);
		contenedorAtributo.setAlignment(Pos.TOP_RIGHT);
		contenedorAtributo.setPadding(new Insets(3));
		contenedorAtributo.getChildren().addAll(label,pb);
		return contenedorAtributo;
		
	}
}
