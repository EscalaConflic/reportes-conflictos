<?php
/* @var $this AlcanceController */
/* @var $model Alcance */

$this->breadcrumbs=array(
	'Alcances'=>array('index'),
	$model->id=>array('view','id'=>$model->id),
	'Update',
);

$this->menu=array(
	array('label'=>'List Alcance', 'url'=>array('index')),
	array('label'=>'Create Alcance', 'url'=>array('create')),
	array('label'=>'View Alcance', 'url'=>array('view', 'id'=>$model->id)),
	array('label'=>'Manage Alcance', 'url'=>array('admin')),
);
?>

<h1>Update Alcance <?php echo $model->id; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>