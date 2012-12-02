<?php
/* @var $this ConflictoController */
/* @var $model Conflicto */

$this->breadcrumbs=array(
	'Conflictos'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List Conflicto', 'url'=>array('index')),
	array('label'=>'Create Conflicto', 'url'=>array('create')),
	array('label'=>'Update Conflicto', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete Conflicto', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage Conflicto', 'url'=>array('admin')),
);
?>

<h1>View Conflicto #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'tblTipoConflicto_id',
		'tblSectorDemandado_id',
		'tblSectorDemandante_id',
		'tblUsuarios_id',
		'tblUbicacion_id',
		'tblAlcance_id',
		'tblAmbito_id',
		'con_medida',
		'con_latitud',
		'con_longitud',
		'con_fecha',
		'con_asunto',
		'con_estado',
		'con_salida',
		'con_fuente',
		'con_nivel',
	),
)); ?>
