<?php
/* @var $this TipoConflictoController */
/* @var $dataProvider CActiveDataProvider */

$this->breadcrumbs=array(
	'Tipo Conflictos',
);

$this->menu=array(
	array('label'=>'Create TipoConflicto', 'url'=>array('create')),
	array('label'=>'Manage TipoConflicto', 'url'=>array('admin')),
);
?>

<h1>Tipo Conflictos</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
