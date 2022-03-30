'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    let resource = null;
    const elem = document.querySelector('.modal-body-buttons');
    const container = document.querySelector('#modal-hint');
    const observer = new MutationObserver(async (mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;

                if (node.matches('form#FormToEditCourse')){
                    node.addEventListener('submit', async (event) => {
                        event.preventDefault();
                        const data = new FormData(node);
                        const object = {};
                        data.forEach((value, key) => {
                            if (key === 'id-holder') {
                                resource = `http://localhost:8080/courses/edit/${value}`;
                            } else if (
                                key === 'add_students_ids' ||
                                key === 'add_professors_ids' ||
                                key === 'delete_professors_ids' ||
                                key === 'delete_students_ids'
                            ) {
                                if (value) {
                                    object[key] = value.split(',');
                                    object[key] = object[key].map((x) => {
                                        return parseInt(x, 10);
                                    });
                                }
                            } else {
                                object[key] = value;
                            }
                        });
                        const success = await postData(object, resource, container, elem);
                        if (success) {
                            container.textContent = 'Курс успешно обновлен!';
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