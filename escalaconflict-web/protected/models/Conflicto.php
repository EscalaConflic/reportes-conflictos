<?php

/**
 * This is the model class for table "{{Conflicto}}".
 *
 * The followings are the available columns in table '{{Conflicto}}':
 * @property integer $id
 * @property integer $tblTipoConflicto_id
 * @property integer $tblSectorDemandado_id
 * @property integer $tblSectorDemandante_id
 * @property integer $tblUsuarios_id
 * @property integer $tblUbicacion_id
 * @property integer $tblAlcance_id
 * @property integer $tblAmbito_id
 * @property string $con_medida
 * @property string $con_latitud
 * @property string $con_longitud
 * @property string $con_fecha
 * @property string $con_asunto
 * @property integer $con_estado
 * @property string $con_salida
 * @property string $con_fuente
 * @property integer $con_nivel
 *
 * The followings are the available model relations:
 * @property TipoConflicto $tblTipoConflicto
 * @property SectorDemandado $tblSectorDemandado
 * @property SectorDemandante $tblSectorDemandante
 * @property Ubicacion $tblUbicacion
 * @property Usuarios $tblUsuarios
 * @property Alcance $tblAlcance
 * @property Ambito $tblAmbito
 */
class Conflicto extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @param string $className active record class name.
	 * @return Conflicto the static model class
	 */
	public static function model($className=__CLASS__)
	{
		return parent::model($className);
	}
	
	/**
	 * @return string the associated database table name
	 */
	public function tableName()
	{
		return '{{Conflicto}}';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('tblTipoConflicto_id, tblSectorDemandado_id, tblSectorDemandante_id, tblUsuarios_id, tblUbicacion_id, tblAlcance_id, tblAmbito_id, con_latitud, con_longitud, con_fecha, con_asunto', 'required'),
			array('tblTipoConflicto_id, tblSectorDemandado_id, tblSectorDemandante_id, tblUsuarios_id, tblUbicacion_id, tblAlcance_id, tblAmbito_id, con_estado, con_nivel', 'numerical', 'integerOnly'=>true),
			array('con_medida, con_asunto, con_salida, con_fuente', 'length', 'max'=>255),
			array('con_latitud, con_longitud', 'length', 'max'=>10),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id, tblTipoConflicto_id, tblSectorDemandado_id, tblSectorDemandante_id, tblUsuarios_id, tblUbicacion_id, tblAlcance_id, tblAmbito_id, con_medida, con_latitud, con_longitud, con_fecha, con_asunto, con_estado, con_salida, con_fuente, con_nivel', 'safe', 'on'=>'search'),
		);
	}

	/**
	 * @return array relational rules.
	 */
	public function relations()
	{
		// NOTE: you may need to adjust the relation name and the related
		// class name for the relations automatically generated below.
		return array(
			'tblTipoConflicto' => array(self::BELONGS_TO, 'TipoConflicto', 'tblTipoConflicto_id'),
			'tblSectorDemandado' => array(self::BELONGS_TO, 'SectorDemandado', 'tblSectorDemandado_id'),
			'tblSectorDemandante' => array(self::BELONGS_TO, 'SectorDemandante', 'tblSectorDemandante_id'),
			'tblUbicacion' => array(self::BELONGS_TO, 'Ubicacion', 'tblUbicacion_id'),
			'tblUsuarios' => array(self::BELONGS_TO, 'Usuarios', 'tblUsuarios_id'),
			'tblAlcance' => array(self::BELONGS_TO, 'Alcance', 'tblAlcance_id'),
			'tblAmbito' => array(self::BELONGS_TO, 'Ambito', 'tblAmbito_id'),
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id' => 'ID',
			'tblTipoConflicto_id' => 'Tbl Tipo Conflicto',
			'tblSectorDemandado_id' => 'Tbl Sector Demandado',
			'tblSectorDemandante_id' => 'Tbl Sector Demandante',
			'tblUsuarios_id' => 'Tbl Usuarios',
			'tblUbicacion_id' => 'Tbl Ubicacion',
			'tblAlcance_id' => 'Tbl Alcance',
			'tblAmbito_id' => 'Tbl Ambito',
			'con_medida' => 'Con Medida',
			'con_latitud' => 'Con Latitud',
			'con_longitud' => 'Con Longitud',
			'con_fecha' => 'Con Fecha',
			'con_asunto' => 'Con Asunto',
			'con_estado' => 'Con Estado',
			'con_salida' => 'Con Salida',
			'con_fuente' => 'Con Fuente',
			'con_nivel' => 'Con Nivel',
		);
	}

	/**
	 * Retrieves a list of models based on the current search/filter conditions.
	 * @return CActiveDataProvider the data provider that can return the models based on the search/filter conditions.
	 */
	public function search()
	{
		// Warning: Please modify the following code to remove attributes that
		// should not be searched.

		$criteria=new CDbCriteria;

		$criteria->compare('id',$this->id);
		$criteria->compare('tblTipoConflicto_id',$this->tblTipoConflicto_id);
		$criteria->compare('tblSectorDemandado_id',$this->tblSectorDemandado_id);
		$criteria->compare('tblSectorDemandante_id',$this->tblSectorDemandante_id);
		$criteria->compare('tblUsuarios_id',$this->tblUsuarios_id);
		$criteria->compare('tblUbicacion_id',$this->tblUbicacion_id);
		$criteria->compare('tblAlcance_id',$this->tblAlcance_id);
		$criteria->compare('tblAmbito_id',$this->tblAmbito_id);
		$criteria->compare('con_medida',$this->con_medida,true);
		$criteria->compare('con_latitud',$this->con_latitud,true);
		$criteria->compare('con_longitud',$this->con_longitud,true);
		$criteria->compare('con_fecha',$this->con_fecha,true);
		$criteria->compare('con_asunto',$this->con_asunto,true);
		$criteria->compare('con_estado',$this->con_estado);
		$criteria->compare('con_salida',$this->con_salida,true);
		$criteria->compare('con_fuente',$this->con_fuente,true);
		$criteria->compare('con_nivel',$this->con_nivel);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}