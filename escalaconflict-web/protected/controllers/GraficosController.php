<?php

class GraficosController extends Controller {

    /**
     * @var string the default layout for the views. Defaults to '//layouts/column2', meaning
     * using two-column layout. See 'protected/views/layouts/column2.php'.
     */
    public $layout = '//layouts/column2';

    public function actionIndex() {

        $this->render('index');
    }

    public function actionDatos() {
        echo json_encode(
                array(
                    array('data1' => 10, 'data2' => 12, 'name' => 'enero'),
                    array('data1' => 13, 'data2' => 10, 'name' => 'febrero'),
                    array('data1' => 10, 'data2' => 13, 'name' => 'marzo'),
                    array('data1' => 10, 'data2' => 12, 'name' => 'abril'),
                    array('data1' => 11, 'data2' => 16, 'name' => 'mayo'),
                    array('data1' => 10, 'data2' => 16, 'name' => 'junio'),
                    array('data1' => 12, 'data2' => 17, 'name' => 'julio'),
                    array('data1' => 10, 'data2' => 16, 'name' => 'agosto'),
                    array('data1' => 11, 'data2' => 13, 'name' => 'septiembre'),
                    array('data1' => 12, 'data2' => 17, 'name' => 'octubre'),
                    array('data1' => 10, 'data2' => 15, 'name' => 'noviembre'),
                    array('data1' => 4, 'data2' => 18, 'name' => 'diciembre')
                )
        );
        exit();
        $this->render(false);
    }
    
    public function actionTipomes(){
    	$mes=$_POST['MES']?$_POST['MES']:$_GET['MES'];
    	$mes=$mes=='A'?7:($mes=='B'?8:9);
    	//echo json_encode(array('MES'=>$mes));exit();
    	//if(strlen($mes)>0){
    		$connection=Yii::app()->db;
		$command=$connection->createCommand("select concat(substring(t.tp_nombre,1,15),'.') AS 'TIPO', count(*) AS 'CANTIDAD' from tblConflicto c, tblTipoConflicto t where c.tblTipoConflicto_id=t.id and MONTH(c.con_fecha)='".$mes."' group by t.tp_nombre");
		$dataReader=$command->queryAll();
		echo json_encode($dataReader);
	//}
	//else{print_r(json_encode(array('res'=>false)));}
	exit();
    }

    public function actionDemandante() {
        $criteria = new CDbCriteria();
        $criteria->order = 'id';
        $secDemandante = SectorDemandante::model()->findAll($criteria);
        $secDemte = array();
        foreach ($secDemandante as $sde) {
            $secDemte[] = array(utf8_decode($sde->id)=> $sde->sde_nombre);
        }
        //echo CJSON::encode($tipoConflicto);        
        header('Content-type:application/json');
        echo json_encode($secDemte);
        
    }

}