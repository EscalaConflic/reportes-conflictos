<?php 
Yii::app()->getClientScript()->registerCssFile(Yii::app()->baseUrl . '/assets/extjs/resources/css/ext-all.css');
Yii::app()->getClientScript()->registerScriptFile(Yii::app()->baseUrl . '/assets/extjs/ext-all.js');

?>
<script type="text/javascript">
    Ext.require('Ext.data.*');
    Ext.require('Ext.chart.*');
    Ext.require('Ext.layout.container.Fit');
    Ext.onReady(function(){
        var myData = [{"data1":10,"data2":12,"name":"enero"},{"data1":13,"data2":10,"name":"febrero"},{"data1":10,"data2":13,"name":"marzo"},{"data1":10,"data2":12,"name":"abril"},{"data1":11,"data2":16,"name":"mayo"},{"data1":10,"data2":16,"name":"junio"},{"data1":12,"data2":17,"name":"julio"},{"data1":10,"data2":16,"name":"agosto"},{"data1":11,"data2":13,"name":"septiembre"},{"data1":12,"data2":17,"name":"octubre"},{"data1":10,"data2":15,"name":"noviembre"},{"data1":4,"data2":18,"name":"diciembre"}];
        Ext.define('Datos', {
            extend: 'Ext.data.Model',
            idProperty: 'value',
            fields:
                [{
                    name: 'TIPO', 
                    type: 'string'
                }, {
                    name: 'CANTIDAD', 
                    type: 'number'
                }]
        });
        var store1 = new Ext.data.Store({
            model: 'Datos',
            autoLoad: false,
            proxy: new Ext.data.HttpProxy({
                url:'/escalaconflict/graficos/tipomes',
                //url:'/escalaconflict/graficos/datos',
                method: 'POST',
                reader:{
                    fields: ['TIPO', 'CANTIDAD'],
                    type:'json',
                    root: 'roles'
                }
            })
            //fields: ['name', 'data1', 'data2'],
            //data: myData
        });
        store1.load({params:{MES:7}});
        var donut = false,
        panel1 = Ext.create('widget.panel', {
            width: 690,
            height: 700,
            title: 'Conflictos por Meses',
            renderTo: 'cuerpo',
            layout: 'fit',
            tbar: [{
                    text: 'Julio',
                    handler: function() {
                        store1.load({params:{MES:'A'}});
                        var chart = Ext.getCmp('chartCmp');
                        chart.refresh();
                    }
                }, {
                    text: 'Agosto',
                    handler: function() {
                        store1.load({params:{MES:'B'}});
                        var chart = Ext.getCmp('chartCmp');
                        chart.refresh();
                    }
                }, {
                    text: 'Septiembre',
                    handler: function() {
                        store1.load({params:{MES:'C'}});
                        var chart = Ext.getCmp('chartCmp');
                        chart.refresh();
                    }
                }, {
                    enableToggle: true,
                    pressed: false,
                    text: 'Dona',
                    toggleHandler: function(btn, pressed) {
                        var chart = Ext.getCmp('chartCmp');
                        chart.series.first().donut = pressed ? 35 : false;
                        chart.refresh();
                    }
                }],
            items: {
                xtype: 'chart',
                id: 'chartCmp',
                animate: true,
                store: store1,
                shadow: true,
                legend: {
                    position: 'bottom'
                },
                insetPadding: 50,
                theme: 'Base:gradients',
                series: [{
                        type: 'pie',
                        field: 'CANTIDAD',
                        showInLegend: true,
                        donut: donut,
                        tips: {
                            trackMouse: true,
                            width: 140,
                            height: 28,
                            renderer: function(storeItem, item) {
                                //calculate percentage.
                                var total = 0;
                                store1.each(function(rec) {
                                    total += rec.get('CANTIDAD');
                                });
                                this.setTitle(storeItem.get('TIPO') + ': ' + Math.round(storeItem.get('CANTIDAD') / total * 100) + '%');
                            }
                        },
                        highlight: {
                            segment: {
                                margin: 20
                            }
                        },
                        label: {
                            field: 'TIPO',
                            display: 'rotate',
                            contrast: true,
                            font: '15px Arial'
                        }
                    }]
            }
        });
        store1.load({params:{MES:7}});
    });
</script>
<div id="cuerpo"></div>