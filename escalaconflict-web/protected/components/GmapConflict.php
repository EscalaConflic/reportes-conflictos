<?php

class GmapConflict extends CApplicationComponent {

    protected $latitud;
    protected $longitud;
    protected $zoom;
    protected $descripcion;
    protected $dimension;

    public function showMap($_latitud, $_longitud, $_zoom=NULL, $_descripcion=NULL, $_dimension=NULL) {
        Yii::import('ext.gmap.*');
        $gMap = new EGMap();
        $gMap->setWidth($_dimension);
        $gMap->setHeight($_dimension);
        $gMap->zoom = $_zoom;
        $gMap->setCenter($_latitud, $_longitud);
        $info_window = new EGMapInfoWindow('<div>'.$_descripcion.'</div>');
        $icon = new EGMapMarkerImage("http://google-maps-icons.googlecode.com/files/gazstation.png");
        $icon->setSize(32, 37);
        $icon->setAnchor(16, 16.5);
        $icon->setOrigin(0, 0);
        $marker = new EGMapMarker($_latitud, $_longitud, array('title' => '"My Town"', 'icon' => $icon));
        $marker2 = new EGMapMarker($_latitud, $_longitud, array('title' => '"My 2 Town"'));
        $marker->addHtmlInfoWindow($info_window);
        $gMap->addMarker($marker);
        $gMap->addMarker($marker2);
        $gMap->renderMap();
    }

}

?>
