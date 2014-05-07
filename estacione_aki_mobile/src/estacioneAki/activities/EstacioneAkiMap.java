package estacioneAki.activities;

import java.io.InputStream;
import java.util.Iterator;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import estacioneAki.util.Estacionamento;
import estacioneAki.util.EstacionamentoList;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;

public class EstacioneAkiMap extends Activity {

	private GoogleMap mMap;
	
	Iterator<Estacionamento> leXMLLocal() throws Exception{
		
		AssetManager assetMan = getAssets();
		InputStream is = assetMan.open("listaEstacionamento.xml");
		Serializer serializer = new Persister();
        EstacionamentoList estList = serializer.read(EstacionamentoList.class, is);
        Iterator<Estacionamento> iterList = estList.estaciomentoList.iterator();
        return iterList;
 	}	

	void plotaEstacionamentosNoMapa(Iterator<Estacionamento> iterList){
	    while(iterList.hasNext()){
	    	Estacionamento e = (Estacionamento) iterList.next();
	    	MarkerOptions marker = new MarkerOptions();
	    	LatLng position = new LatLng(new Double(e.getLatitude()).doubleValue(), new Double(e.getLongitude()).doubleValue());
	        marker.position(position);
	        marker.title(e.getNome());
	        marker.snippet(e.getEndereco()+". Preço/hora: R$"+e.getPrecoHora());
	        mMap.addMarker(marker);
	    } 
	}
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_estacione_aki_map);
       mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
       try {
    	   //Iterator<Estacionamento> iterList = (Iterator<Estacionamento>) sc.execute();
    	   Iterator<Estacionamento> iterList = leXMLLocal();
    	   plotaEstacionamentosNoMapa(iterList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}