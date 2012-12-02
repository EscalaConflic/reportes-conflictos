<?php
/* @var $this AmbitoController */
/* @var $model Ambito */

$this->breadcrumbs=array(
	'Ambitos'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List Ambito', 'url'=>array('index')),
	array('label'=>'Manage Ambito', 'url'=>array('admin')),
);
?>

<h1>Create Ambito</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>