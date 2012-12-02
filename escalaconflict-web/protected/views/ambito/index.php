<?php
/* @var $this AmbitoController */
/* @var $dataProvider CActiveDataProvider */

$this->breadcrumbs=array(
	'Ambitos',
);

$this->menu=array(
	array('label'=>'Create Ambito', 'url'=>array('create')),
	array('label'=>'Manage Ambito', 'url'=>array('admin')),
);
?>

<h1>Ambitos</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
