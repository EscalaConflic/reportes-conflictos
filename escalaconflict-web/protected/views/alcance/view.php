<?php
/* @var $this AlcanceController */
/* @var $model Alcance */

$this->breadcrumbs=array(
	'Alcances'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List Alcance', 'url'=>array('index')),
	array('label'=>'Create Alcance', 'url'=>array('create')),
	array('label'=>'Update Alcance', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete Alcance', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage Alcance', 'url'=>array('admin')),
);
?>

<h1>View Alcance #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'alc_nombre',
	),
)); ?>
