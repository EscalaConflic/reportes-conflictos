<?php
/* @var $this TipoConflictoController */
/* @var $model TipoConflicto */

$this->breadcrumbs=array(
	'Tipo Conflictos'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List TipoConflicto', 'url'=>array('index')),
	array('label'=>'Create TipoConflicto', 'url'=>array('create')),
	array('label'=>'View TipoConflicto', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage TipoConflicto', 'url'=>array('admin')),
);
?>

<h1>Update TipoConflicto <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>