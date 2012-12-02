<?php
/* @var $this CampoConflictoController */
/* @var $model CampoConflicto */

$this->breadcrumbs=array(
	'Campo Conflictos'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List CampoConflicto', 'url'=>array('index')),
	array('label'=>'Create CampoConflicto', 'url'=>array('create')),
	array('label'=>'Update CampoConflicto', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete CampoConflicto', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage CampoConflicto', 'url'=>array('admin')),
);
?>

<h1>View CampoConflicto #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'cc_nombre',
		'cc_descripccion',
	),
)); ?>
