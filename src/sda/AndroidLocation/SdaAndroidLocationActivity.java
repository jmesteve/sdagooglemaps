package sda.AndroidLocation;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;

public class SdaAndroidLocationActivity extends MapActivity implements LocationListener {
    /** Called when the activity is first created. */

	
	MapView mapView;
	MapController mc;
	GeoPoint p;
	private LocationManager lm;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mapView=(MapView)findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        mc=mapView.getController();

        String coordinates[]={"39.48167","-0.34361"}; 
        double lat=Double.parseDouble(coordinates[0]); 
        double lng=Double.parseDouble(coordinates[1]); 
        p=new GeoPoint((int)(lat*1E6), (int)(lng*1E6)); 
        mc.animateTo(p); 
        mc.setZoom(13);
        
	    // Completar -> PONER EL LISTENER
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }
    
    protected boolean isRouteDisplayed() {
    	return false;
    }

	@Override
	public void onLocationChanged(Location location) {

		// completar
		if (location != null){
			p = new GeoPoint((int)(location.getLatitude()*1E6),(int)(location.getLongitude()*1E6));
			mc.animateTo(p);
			mc.setZoom(13);
		}
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}