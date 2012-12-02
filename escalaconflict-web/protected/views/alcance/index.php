<?php
/* @var $this AlcanceController */
/* @var $dataProvider CActiveDataProvider */

$this->breadcrumbs=array(
	'Alcances',
);

$this->menu=array(
	array('label'=>'Create Alcance', 'url'=>array('create')),
	array('label'=>'Manage Alcance', 'url'=>array('admin')),
);
?>

<h1>Alcances</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
