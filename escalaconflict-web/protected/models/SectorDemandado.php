<?php

/**
 * This is the model class for table "{{SectorDemandado}}".
 *
 * The followings are the available columns in table '{{SectorDemandado}}':
 * @property integer $id
 * @property integer $tblSectores_id
 * @property string $sdo_nombre
 *
 * The followings are the available model relations:
 * @property Conflicto[] $conflictos
 * @property Sectores $tblSectores
 */
class SectorDemandado extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @param string $className active record class name.
	 * @return SectorDemandado the static model class
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
		return '{{SectorDemandado}}';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('tblSectores_id, sdo_nombre', 'required'),
			array('tblSectores_id', 'numerical', 'integerOnly'=>true),
			array('sdo_nombre', 'length', 'max'=>45),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id, tblSectores_id, sdo_nombre', 'safe', 'on'=>'search'),
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
			'conflictos' => array(self::HAS_MANY, 'Conflicto', 'tblSectorDemandado_id'),
			'tblSectores' => array(self::BELONGS_TO, 'Sectores', 'tblSectores_id'),
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id' => 'ID',
			'tblSectores_id' => 'Tbl Sectores',
			'sdo_nombre' => 'Sdo Nombre',
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
		$criteria->compare('tblSectores_id',$this->tblSectores_id);
		$criteria->compare('sdo_nombre',$this->sdo_nombre,true);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}