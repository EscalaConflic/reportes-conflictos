<?php
/* @var $this ConflictoController */
/* @var $model Conflicto */

$this->breadcrumbs=array(
	'Conflictos'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List Conflicto', 'url'=>array('index')),
	array('label'=>'Create Conflicto', 'url'=>array('create')),
	array('label'=>'View Conflicto', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage Conflicto', 'url'=>array('admin')),
);
?>

<h1>Update Conflicto <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>