package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurMarina;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modele.Flotte;

public class VueMarina extends Vue {

	protected ControleurMarina controleur;
	protected static VueMarina instance = null; 
	public static VueMarina getInstance() {if(null==instance)instance = new VueMarina();return VueMarina.instance;}; 
	
	private VueMarina() 
	{
		super("marina.fxml", VueMarina.class,995,617); 
		super.controleur = this.controleur = new ControleurMarina();
		Logger.logMsg(Logger.INFO, "new VueMarina()");
	}
		
	public void activerControles()
	{
		super.activerControles();
	}
	
	public void afficherFlottes(List<Flotte> flottes)
	{
		Logger.logMsg(Logger.INFO, "VueMarina.afficherFlottes()");
		VBox vueFlottes = (VBox)lookup("#liste-flottes");
		System.out.println(vueFlottes);
		
		vueFlottes.getChildren().clear();
		
		for(Flotte flotte:flottes)
		{
			Logger.logMsg(Logger.INFO,"Flotte recue par la vue " + flotte.getNom());
									
			HBox vueNouvelleFlotte = new HBox();
			vueNouvelleFlotte.getStyleClass().add("flotte");
			vueNouvelleFlotte.setPadding(new Insets(15, 12, 15, 12));
			vueNouvelleFlotte.setSpacing(10);
			
			ImageView vueIcone = new ImageView();
			vueIcone.setImage(new Image("vue/decoration/petit-bateau-blanc.png"));
			vueIcone.setFitHeight(40);
			vueIcone.setFitWidth( 40 );
			vueNouvelleFlotte.getChildren().add(vueIcone);
			
			Label vueTitre = new Label(flotte.getNom());
			vueTitre.getStyleClass().add("titre");
			vueTitre.setStyle("-fx-font: 24 arial;");
			vueNouvelleFlotte.getChildren().add(vueTitre);
			
			Button action = new Button("Consulter");
			action.setId(flotte.getId()+"");
			action.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Button source = (Button)e.getSource();
					Logger.logMsg(Logger.INFO, "Clic sur la flotte " + source.getId());		
					controleur.reagirClicFlotte(Integer.parseInt(source.getId()));
				}});			
			vueNouvelleFlotte.getChildren().add(action);
			
			vueFlottes.getChildren().add((vueNouvelleFlotte));
		}		
	}
	
	public void afficherNombreFlottes(int nombreFlottes)
	{
		Logger.logMsg(Logger.INFO, "VueMarina.afficherNombreFlottes()");
		
		Label vueNombreFlottes = (Label)lookup("#nombre-flottes");
		vueNombreFlottes.setText(nombreFlottes + " FLOTTES");
		
	}
	
}
