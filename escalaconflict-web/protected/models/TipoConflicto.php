<?php

/**
 * This is the model class for table "{{TipoConflicto}}".
 *
 * The followings are the available columns in table '{{TipoConflicto}}':
 * @property integer $id
 * @property integer $tblCampoConflicto_id
 * @property string $tp_nombre
 * @property string $tp_descripcion
 *
 * The followings are the available model relations:
 * @property Conflicto[] $conflictos
 * @property CampoConflicto $tblCampoConflicto
 */
class TipoConflicto extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @param string $className active record class name.
	 * @return TipoConflicto the static model class
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
		return '{{TipoConflicto}}';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('tblCampoConflicto_id, tp_nombre', 'required'),
			array('tblCampoConflicto_id', 'numerical', 'integerOnly'=>true),
			array('tp_nombre', 'length', 'max'=>200),
			array('tp_descripcion', 'safe'),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id, tblCampoConflicto_id, tp_nombre, tp_descripcion', 'safe', 'on'=>'search'),
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
			'conflictos' => array(self::HAS_MANY, 'Conflicto', 'tblTipoConflicto_id'),
			'tblCampoConflicto' => array(self::BELONGS_TO, 'CampoConflicto', 'tblCampoConflicto_id'),
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id' => 'ID',
			'tblCampoConflicto_id' => 'Tbl Campo Conflicto',
			'tp_nombre' => 'Tp Nombre',
			'tp_descripcion' => 'Tp Descripcion',
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
		$criteria->compare('tblCampoConflicto_id',$this->tblCampoConflicto_id);
		$criteria->compare('tp_nombre',$this->tp_nombre,true);
		$criteria->compare('tp_descripcion',$this->tp_descripcion,true);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}