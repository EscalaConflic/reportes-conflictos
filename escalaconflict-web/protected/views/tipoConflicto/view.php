<?php
/* @var $this TipoConflictoController */
/* @var $model TipoConflicto */

$this->breadcrumbs=array(
	'Tipo Conflictos'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List TipoConflicto', 'url'=>array('index')),
	array('label'=>'Create TipoConflicto', 'url'=>array('create')),
	array('label'=>'Update TipoConflicto', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete TipoConflicto', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage TipoConflicto', 'url'=>array('admin')),
);
?>

<h1>View TipoConflicto #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'tblCampoConflicto_id',
		'tp_nombre',
		'tp_descripcion',
	),
)); ?>
