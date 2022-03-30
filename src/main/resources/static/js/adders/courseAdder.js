'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    const resource = 'http://localhost:8080/courses/add/';
    const elem = document.querySelector('.modal-body-buttons');
    const container = document.querySelector('#modal-hint');
    const observer = new MutationObserver(async (mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;

                if (node.matches('form#FormToAddCourse')){
                    node.addEventListener('submit', async (event) => {
                        event.preventDefault();
                        const data = new FormData(node);
                        const object = {};
                        data.forEach((value, key) => {
                            if (key !== 'add_students_ids' && key !== 'add_professors_ids') {
                                object[key] = value;
                            } else {
                                if (value) {
                                    object[key] = value.split(',');
                                    object[key] = object[key].map((x) => {
                                        return parseInt(x, 10);
                                    });
                                }
                            }
                        });
                        if (!object['add_professors_ids']) {
                            delete object['add_professors_ids'];
                        }
                        if (!object['add_students_ids']) {
                            delete object['add_students_ids'];
                        }
                        const success = await postData(object, resource, container, elem);
                        if (success) {
                            container.textContent = 'Курс успешно добавлен!';
                        } else {
                            container.textContent = 'Возникла ошибка. Попробуйте еще раз или перезагрузите страницу';
                        }
                    });
                }
            }
        });
    });
    const config = {childList: true, subtree: true};
    observer.observe(elem, config);
});