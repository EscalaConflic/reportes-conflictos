<?php
/* @var $this SectoresController */
/* @var $model Sectores */

$this->breadcrumbs=array(
	'Sectores'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List Sectores', 'url'=>array('index')),
	array('label'=>'Create Sectores', 'url'=>array('create')),
	array('label'=>'View Sectores', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage Sectores', 'url'=>array('admin')),
);
?>

<h1>Update Sectores <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>