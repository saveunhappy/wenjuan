const toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
})
Toast = {
    success:function (message){
        toast.fire({
            icon: 'success',
            title: message
        })
    },
    error:function (message){
        toast.fire({
            icon: 'error',
            title: message
        })
    },
    warning:function (message){
        toast.fire({
            icon: 'warning',
            title: message
        })
    },
}

//
// Toast = {
//     success:function (message){
//         Swal.fire({
//             position: 'top-end',
//             icon: 'success',
//             title: message,
//             showConfirmButton: false,
//             timer: 1500
//         })
//     },
//     error:function (message){
//         Swal.fire({
//             position: 'top-end',
//             icon: 'error',
//             title: message,
//             showConfirmButton: false,
//             timer: 1500
//         })
//     },
//     warning:function (message){
//         Swal.fire({
//             position: 'top-end',
//             icon: 'warning',
//             title: message,
//             showConfirmButton: false,
//             timer: 1500
//         })
//     },
// }
