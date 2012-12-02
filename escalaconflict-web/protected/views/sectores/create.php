<?php
/* @var $this SectoresController */
/* @var $model Sectores */

$this->breadcrumbs=array(
	'Sectores'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List Sectores', 'url'=>array('index')),
	array('label'=>'Manage Sectores', 'url'=>array('admin')),
);
?>

<h1>Create Sectores</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>