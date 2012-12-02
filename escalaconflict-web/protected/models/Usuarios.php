<?php

/**
 * This is the model class for table "{{Usuarios}}".
 *
 * The followings are the available columns in table '{{Usuarios}}':
 * @property integer $id
 * @property string $usr_nick
 * @property string $usr_password
 * @property integer $usr_tipousuario
 * @property string $usr_correo
 * @property integer $usr_nivelconfianza
 * @property integer $usr_estado
 * @property string $usr_imei
 *
 * The followings are the available model relations:
 * @property Conflicto[] $conflictos
 */
class Usuarios extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @param string $className active record class name.
	 * @return Usuarios the static model class
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
		return '{{Usuarios}}';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('usr_tipousuario, usr_nivelconfianza, usr_estado', 'numerical', 'integerOnly'=>true),
			array('usr_nick, usr_imei', 'length', 'max'=>45),
			array('usr_password, usr_correo', 'length', 'max'=>100),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id, usr_nick, usr_password, usr_tipousuario, usr_correo, usr_nivelconfianza, usr_estado, usr_imei', 'safe', 'on'=>'search'),
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
			'conflictos' => array(self::HAS_MANY, 'Conflicto', 'tblUsuarios_id'),
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id' => 'ID',
			'usr_nick' => 'Usr Nick',
			'usr_password' => 'Usr Password',
			'usr_tipousuario' => 'Usr Tipousuario',
			'usr_correo' => 'Usr Correo',
			'usr_nivelconfianza' => 'Usr Nivelconfianza',
			'usr_estado' => 'Usr Estado',
			'usr_imei' => 'Usr Imei',
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
		$criteria->compare('usr_nick',$this->usr_nick,true);
		$criteria->compare('usr_password',$this->usr_password,true);
		$criteria->compare('usr_tipousuario',$this->usr_tipousuario);
		$criteria->compare('usr_correo',$this->usr_correo,true);
		$criteria->compare('usr_nivelconfianza',$this->usr_nivelconfianza);
		$criteria->compare('usr_estado',$this->usr_estado);
		$criteria->compare('usr_imei',$this->usr_imei,true);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}