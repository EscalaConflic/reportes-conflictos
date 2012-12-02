<?php
/* @var $this AmbitoController */
/* @var $model Ambito */

$this->breadcrumbs=array(
	'Ambitos'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List Ambito', 'url'=>array('index')),
	array('label'=>'Create Ambito', 'url'=>array('create')),
	array('label'=>'Update Ambito', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete Ambito', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage Ambito', 'url'=>array('admin')),
);
?>

<h1>View Ambito #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'amb_nombre',
	),
)); ?>
