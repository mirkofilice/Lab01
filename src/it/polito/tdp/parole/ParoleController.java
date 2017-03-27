package it.polito.tdp.parole;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco = new Parole() ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnCancella;

    @FXML
    void doCancella(ActionEvent event) {	//tempi di cancellazione simili perchè sia con ARRAY che con LINKED devo prima
    										//scorrere la lista per trovare l'elemento e  questa operazione richiede
    	double t1=System.nanoTime();		//circa lo stesso tempo con entrambe le implementazioni
    	
    	elenco.eliminaParola(txtParola.getText());
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco()){
    		result+=p+"\n";
    	}
    	
    	double t2=System.nanoTime();
    	
    	txtResult.setText(result);
    	txtParola.clear();
    	
    	txtTime.setText("Cancellazione avvenuta in "+((t2-t1)/1e9)+" secondi");
    	
    }

    @FXML
    void doInsert(ActionEvent event) {	//tempi di inserimento quasi uguali usando ARRAYlist e LINKEDlist
    	
    	double t1=System.nanoTime();

    	elenco.addParola( txtParola.getText() );
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	double t2=System.nanoTime();
    	
    	txtResult.setText(result);
    	txtParola.clear();
    	
    	txtTime.setText("Inserimento avvenuto in "+((t2-t1)/1e9)+" secondi");
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	double t1=System.nanoTime();

    	elenco.reset() ;
    	
    	double t2=System.nanoTime();
    	
    	txtResult.clear() ;
    	
    	txtTime.setText("Reset avvenuto in "+((t2-t1)/1e9)+" secondi");
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";

    }
}
