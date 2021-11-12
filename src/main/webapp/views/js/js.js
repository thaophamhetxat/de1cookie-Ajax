$(document).ready(function(){
    $('.error').on('click', function(){
        $(this).notifyMe(
            'bottom',
            'error',
            'Lorem Ipsum Text',
            'Lorem ipsum dolos lorem uisnsnd h jsakdh ajkdbh',
            200,
            2000
        );
    });

    $('.info').on('click', function(){
        $(this).notifyMe(
            'top',
            'info',
            'Lorem Ipsum Text',
            'Lorem ipsum dolos lorem uisnsnd h jsakdh ajkdbh',
            300
        );
    });

    $('.success').on('click', function(){
        $(this).notifyMe(
            'left',
            'success',
            'Lorem Ipsum Text',
            'Lorem ipsum dolos lorem uisnsnd h jsakdh ajkdbh',
            400
        );
    });

    $('.default').on('click', function(){
        $(this).notifyMe(
            'right',
            'default',
            'Lorem Ipsum Text',
            'Lorem ipsum dolos lorem uisnsnd h jsakdh ajkdbh',
            500
        );
    });
});