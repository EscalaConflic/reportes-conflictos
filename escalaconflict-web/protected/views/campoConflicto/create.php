<?php
/* @var $this CampoConflictoController */
/* @var $model CampoConflicto */

$this->breadcrumbs=array(
	'Campo Conflictos'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List CampoConflicto', 'url'=>array('index')),
	array('label'=>'Manage CampoConflicto', 'url'=>array('admin')),
);
?>

<h1>Create CampoConflicto</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>