<?php
/* @var $this AmbitoController */
/* @var $model Ambito */

$this->breadcrumbs=array(
	'Ambitos'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List Ambito', 'url'=>array('index')),
	array('label'=>'Create Ambito', 'url'=>array('create')),
	array('label'=>'View Ambito', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage Ambito', 'url'=>array('admin')),
);
?>

<h1>Update Ambito <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>