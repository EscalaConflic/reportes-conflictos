<?php
/* @var $this ConflictoController */
/* @var $model Conflicto */

$this->breadcrumbs=array(
	'Conflictos'=>array('index'),
	'Manage',
);

$this->menu=array(
	array('label'=>'List Conflicto', 'url'=>array('index')),
	array('label'=>'Create Conflicto', 'url'=>array('create')),
);

Yii::app()->clientScript->registerScript('search', "
$('.search-button').click(function(){
	$('.search-form').toggle();
	return false;
});
$('.search-form form').submit(function(){
	$.fn.yiiGridView.update('conflicto-grid', {
		data: $(this).serialize()
	});
	return false;
});
");
?>

<h1>Manage Conflictos</h1>

<p>
You may optionally enter a comparison operator (<b>&lt;</b>, <b>&lt;=</b>, <b>&gt;</b>, <b>&gt;=</b>, <b>&lt;&gt;</b>
or <b>=</b>) at the beginning of each of your search values to specify how the comparison should be done.
</p>

<?php echo CHtml::link('Advanced Search','#',array('class'=>'search-button')); ?>
<div class="search-form" style="display:none">
<?php $this->renderPartial('_search',array(
	'model'=>$model,
)); ?>
</div><!-- search-form -->

<?php $this->widget('zii.widgets.grid.CGridView', array(
	'id'=>'conflicto-grid',
	'dataProvider'=>$model->search(),
	'filter'=>$model,
	'columns'=>array(
		'id',
		'tblTipoConflicto_id',
		'tblSectorDemandado_id',
		'tblSectorDemandante_id',
		'tblUsuarios_id',
		'tblUbicacion_id',
		/*
		'tblAlcance_id',
		'tblAmbito_id',
		'con_medida',
		'con_latitud',
		'con_longitud',
		'con_fecha',
		'con_asunto',
		'con_estado',
		'con_salida',
		'con_fuente',
		'con_nivel',
		*/
		array(
			'class'=>'CButtonColumn',
		),
	),
)); ?>
