<?php
/* @var $this ConflictoController */
/* @var $model Conflicto */

$this->breadcrumbs=array(
	'Conflictos'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List Conflicto', 'url'=>array('index')),
	array('label'=>'Manage Conflicto', 'url'=>array('admin')),
);
?>

<h1>Create Conflicto</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>