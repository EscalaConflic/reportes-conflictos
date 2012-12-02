<?php
/* @var $this TipoConflictoController */
/* @var $model TipoConflicto */

$this->breadcrumbs=array(
	'Tipo Conflictos'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List TipoConflicto', 'url'=>array('index')),
	array('label'=>'Manage TipoConflicto', 'url'=>array('admin')),
);
?>

<h1>Create TipoConflicto</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>