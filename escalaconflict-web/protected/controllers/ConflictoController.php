<?php

class ConflictoController extends Controller {

    /**
     * @var string the default layout for the views. Defaults to '//layouts/column2', meaning
     * using two-column layout. See 'protected/views/layouts/column2.php'.
     */
    public $layout = '//layouts/column2';

    /**
     * @return array action filters
     */
    public function filters() {
        return array(
            'accessControl', // perform access control for CRUD operations
            'postOnly + delete', // we only allow deletion via POST request
        );
    }

    /**
     * Specifies the access control rules.
     * This method is used by the 'accessControl' filter.
     * @return array access control rules
     */
    public function accessRules() {
        return array(
            array('allow', // allow all users to perform 'index' and 'view' actions
                'actions' => array('index', 'view', 'getDemandado', 'getDemandante','getTipoConflicto','SaveMovilConflict', 'saveConflict'),
                'users' => array('*'),
            ),
            array('allow', // allow authenticated user to perform 'create' and 'update' actions
                'actions' => array('create', 'update'),
                'users' => array('@'),
            ),
            array('allow', // allow admin user to perform 'admin' and 'delete' actions
                'actions' => array('admin', 'delete'),
                'users' => array('admin'),
            ),
            array('deny', // deny all users
                'users' => array('*'),
            ),
        );
    }

    /**
     * Displays a particular model.
     * @param integer $id the ID of the model to be displayed
     */
    public function actionView($id) {
        $this->render('view', array(
            'model' => $this->loadModel($id),
        ));
    }

    /**
     * Creates a new model.
     * If creation is successful, the browser will be redirected to the 'view' page.
     */
    public function actionCreate() {
        $model = new Conflicto;

        // Uncomment the following line if AJAX validation is needed
        // $this->performAjaxValidation($model);

        if (isset($_POST['Conflicto'])) {
            $model->attributes = $_POST['Conflicto'];
            if ($model->save())
                $this->redirect(array('view', 'id' => $model->id));
        }

        $this->render('create', array(
            'model' => $model,
        ));
    }

    /**
     * Updates a particular model.
     * If update is successful, the browser will be redirected to the 'view' page.
     * @param integer $id the ID of the model to be updated
     */
    public function actionUpdate($id) {
        $model = $this->loadModel($id);

        // Uncomment the following line if AJAX validation is needed
        // $this->performAjaxValidation($model);

        if (isset($_POST['Conflicto'])) {
            $model->attributes = $_POST['Conflicto'];
            if ($model->save())
                $this->redirect(array('view', 'id' => $model->id));
        }

        $this->render('update', array(
            'model' => $model,
        ));
    }

    /**
     * Deletes a particular model.
     * If deletion is successful, the browser will be redirected to the 'admin' page.
     * @param integer $id the ID of the model to be deleted
     */
    public function actionDelete($id) {
        $this->loadModel($id)->delete();

        // if AJAX request (triggered by deletion via admin grid view), we should not redirect the browser
        if (!isset($_GET['ajax']))
            $this->redirect(isset($_POST['returnUrl']) ? $_POST['returnUrl'] : array('admin'));
    }

    /**
     * Lists all models.
     */
    public function actionIndex() {
        $dataProvider = new CActiveDataProvider('Conflicto');
        $this->render('index', array(
            'dataProvider' => $dataProvider,
        ));
    }

    /**
     * Manages all models.
     */
    public function actionAdmin() {
        $model = new Conflicto('search');
        $model->unsetAttributes();  // clear any default values
        if (isset($_GET['Conflicto']))
            $model->attributes = $_GET['Conflicto'];

        $this->render('admin', array(
            'model' => $model,
        ));
    }

    /**
     * Returns the data model based on the primary key given in the GET variable.
     * If the data model is not found, an HTTP exception will be raised.
     * @param integer the ID of the model to be loaded
     */
    public function loadModel($id) {
        $model = Conflicto::model()->findByPk($id);
        if ($model === null)
            throw new CHttpException(404, 'The requested page does not exist.');
        return $model;
    }

    /**
     * Performs the AJAX validation.
     * @param CModel the model to be validated
     */
    protected function performAjaxValidation($model) {
        if (isset($_POST['ajax']) && $_POST['ajax'] === 'conflicto-form') {
            echo CActiveForm::validate($model);
            Yii::app()->end();
        }
    }

    public function actionGetDemandante() {
        $criteria = new CDbCriteria();
        $criteria->order = 'id';
        //$criteria->limit = 5;
        $secDemandante = SectorDemandante::model()->findAll($criteria);
        $secDemte = array();
        foreach ($secDemandante as $sde) {
            $secDemte[] = array('id'=>CHtml::encode($sde->id),'sde_nombre' => CHtml::encode($sde->sde_nombre));
        }
        //echo CJSON::encode($tipoConflicto);        
        //header('Content-type:application/json');
        echo CJSON::encode($secDemte);
        exit();
    }

    public function actionGetDemandado() {
        $criteria = new CDbCriteria();
        $criteria->order = 'id';
        //$criteria->limit = 5;
        $secDemandado = SectorDemandado::model()->findAll($criteria);
        $secDemdo = array();
        foreach ($secDemandado as $sdo) {
            $secDemdo[] = array('id'=>CHtml::encode($sdo->id),'sdo_nombre' => CHtml::encode($sdo->sdo_nombre));
        }
        //echo CJSON::encode($tipoConflicto); 
        //header('Content-type:application/json');
        echo CJSON::encode($secDemdo);
        exit();
    }
    
     public function actionGetTipoConflicto(){
        $criteria = new CDbCriteria();        
        $criteria->order = 'id';
        //$criteria->limit = 5;
        $tipoConflicto = TipoConflicto::model()->findAll($criteria);        
        $tipoC = array();
        foreach ($tipoConflicto as $tipo){
            $tipoC[] = array('id'=>CHtml::encode($tipo->id),'tp_nombre'=>  CHtml::encode($tipo->tp_nombre));
        }
        //echo CJSON::encode($tipoConflicto);     
          //header('Content-type:application/json');
        echo CJSON::encode($tipoC);        
        exit();
    }
    
public function actionSaveConflict() {
        $imei = $_POST['imei'];
        $latitud = $_POST['con_latitud'];
        $longitud = $_POST['con_longitud'];
        $tipoConflicto_id = $_POST['tipo_conflicto'];
        $con_asunto = $_POST['descripcion'];
        $sectorDemandado_id = $_POST['sector_demandado'];
        $sectorDemandante_id = $_POST['sector_demandante'];
        $medida = $_POST['medida_presion'];

        if (Usuarios::model()->exists(array('usr_imei' => $imei))) {
            $imeiUser = Usuarios::model()->find(array('usr_imei' => $imei));
            $conflicto = new Conflicto();
            $conflicto->tblTipoConflicto_id = $tipoConflicto_id;
            $conflicto->tblSectorDemandado_id = $sectorDemandado_id;
            $conflicto->tblSectorDemandante_id = $sectorDemandante_id;
            $conflicto->tblUsuarios_id = $imeiUser->id;
            $conflicto->tblUbicacion_id = 1;
            $conflicto->tblAlcance_id = 1;
            $conflicto->tblAmbito_id = 1;
            $conflicto->con_medida = $medida;
            $conflicto->con_latitud = $latitud;
            $conflicto->con_longitud = $longitud;
            $conflicto->con_fecha = date('Y-m-d H:i:s');
            $conflicto->con_asunto = $con_asunto;
            if ($conflicto->save()) {
                echo CJSON::encode(1);
            } else {
                echo CJSON::encode(0);
            }
        } else {
            $usuario = new Usuarios();
            $usuario->usr_imei = $imei;
            if ($usuario->save()) {
                $userImei = Usuarios::model()->find(array('usr_imei' => $imei));
                $conflicto1 = new Conflicto();
                $conflicto1->tblTipoConflicto_id = $tipoConflicto_id;
                $conflicto1->tblSectorDemandado_id = $sectorDemandado_id;
                $conflicto1->tblSectorDemandante_id = $sectorDemandante_id;
                $conflicto1->tblUsuarios_id = $userImei->id;
                $conflicto1->tblUbicacion_id = 1;
                $conflicto1->tblAlcance_id = 1;
                $conflicto1->tblAmbito_id = 1;
                $conflicto1->con_medida = $medida;
                $conflicto1->con_latitud = $latitud;
                $conflicto1->con_longitud = $longitud;
                $conflicto1->con_fecha = date('Y-m-d H:i:s');
                $conflicto1->con_asunto = $con_asunto;
                if ($conflicto1->save()) {
                    echo CJSON::encode(1);
                } else {
                    echo CJSON::encode(0);
                }
            } else {
                echo CJSON::encode(0);
            }
        }
    }


    public function actionSaveMovilConflict(){
        
        $imeiCel = $_POST['imei'];
        if (Usuarios::model()->exists("usr_imei = $imeiCel")) {                        
            $imei = Usuarios::model()->findByAttributes(array('usr_imei' => $imeiCel));            
            $conflicto = new Conflicto();
            $conflicto->con_latitud = round($_POST['con_latitud'],4);
                $conflicto->con_longitud = round($_POST['con_longitud'],4);
            $conflicto->tblTipoConflicto_id = $_POST['tipo_conflicto'];
            $conflicto->con_asunto = $_POST['descripcion'];
            $conflicto->tblSectorDemandado_id = $_POST['sector_demandado'];
            $conflicto->tblSectorDemandante_id = $_POST['sector_demandante'];
            $conflicto->con_medida = $_POST['medida_presion'];
            $conflicto->tblUsuarios_id = $imei->id;
            $conflicto->tblUbicacion_id = 1;
            $conflicto->tblAmbito_id = 1;
            $conflicto->tblAlcance_id = 1;
            $conflicto->con_fecha = date('Y-m-d H:i:s');
            if ($conflicto->save()) {
                echo CJSON::encode(array('estado' => 1));
            } else {
                echo CJSON::encode(array('estado' => 0));               
            }
        } else {            

            $usuario = new Usuarios;
            $usuario->usr_imei = $imeiCel;
            if ($usuario->save()) {
                $imei = Usuarios::model()->findByAttributes(array('usr_imei' => $imeiCel));
                $conflicto = new Conflicto;
                $conflicto->con_latitud = round($_POST['con_latitud'],4);
                $conflicto->con_longitud = round($_POST['con_longitud'],4);
                $conflicto->tblTipoConflicto_id = $_POST['tipo_conflicto'];
                $conflicto->con_asunto = $_POST['descripcion'];
                $conflicto->tblSectorDemandado_id = $_POST['sector_demandado'];
                $conflicto->tblSectorDemandante_id = $_POST['sector_demandante'];
                $conflicto->con_medida = $_POST['medida_presion'];
                $conflicto->tblUsuarios_id = $imei->id;
                $conflicto->tblUbicacion_id = 1;
                $conflicto->tblAmbito_id = 1;
                $conflicto->tblAlcance_id = 1;
                $conflicto->con_fecha = date('Y-m-d H:i:s');
                if ($conflicto->save()) {
                    echo CJSON::encode(array('estado' => 1));
                } else {
                    echo CJSON::encode(array('estado' => 0));
                    //$this->Error();
                }
            } else {
                echo CJSON::encode(array('estado' => 0));
            }
        }
        
    }

}
