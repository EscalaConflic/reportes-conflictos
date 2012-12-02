<?php
/* @var $this CampoConflictoController */
/* @var $model CampoConflicto */

$this->breadcrumbs=array(
	'Campo Conflictos'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List CampoConflicto', 'url'=>array('index')),
	array('label'=>'Create CampoConflicto', 'url'=>array('create')),
	array('label'=>'View CampoConflicto', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage CampoConflicto', 'url'=>array('admin')),
);
?>

<h1>Update CampoConflicto <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>