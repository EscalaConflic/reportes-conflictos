<?php
/* @var $this AlcanceController */
/* @var $model Alcance */

$this->breadcrumbs=array(
	'Alcances'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List Alcance', 'url'=>array('index')),
	array('label'=>'Manage Alcance', 'url'=>array('admin')),
);
?>

<h1>Create Alcance</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>