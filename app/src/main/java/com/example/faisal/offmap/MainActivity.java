package com.example.faisal.offmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {
    private MapView mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inti();


        setMapZoom(9);

        GeoPoint startPoint = new GeoPoint(48.8583, 2.2944);
        setMapCenterView(startPoint);


    }

    private void setMapCenterView(GeoPoint centerPoint) {
        IMapController mapController = mMap.getController();
        mapController.setCenter(centerPoint);
    }

    /**
     * @param zoomLevel level  of zoom
     */

    private void setMapZoom(int zoomLevel) {

        IMapController mapController = mMap.getController();
        mapController.setZoom(zoomLevel);
    }

    /**
     * initialize required component  
     */
    private void inti() {

        setApplicationId();
        mapInit();
    }

    private void mapInit() {
        viewReference();
        setMapDefaultSetting();
    }

    /**
     * @see {@link #inti()}
     * important! set your user agent to prevent getting banned from the osm servers
     */

    private void setApplicationId() {
        org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants.setUserAgentValue(BuildConfig.APPLICATION_ID);
    }

    /**
     * view reference
     */
    private void viewReference() {

        mMap = (MapView) findViewById(R.id.map);
    }

    /**
     * map util setting
     */

    private void setMapDefaultSetting() {
        mMap.setTileSource(TileSourceFactory.MAPNIK);
        mMap.setBuiltInZoomControls(true);
        mMap.setMultiTouchControls(true);
    }
}
