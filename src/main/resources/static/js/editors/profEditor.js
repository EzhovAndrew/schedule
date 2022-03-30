'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    let resource = null;
    const elem = document.querySelector('.modal-body-buttons');
    const container = document.querySelector('#modal-hint');
    const observer = new MutationObserver(async (mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;

                if (node.matches('form#FormToEditProf')){
                    node.addEventListener('submit', async (event) => {
                        event.preventDefault();
                        const data = new FormData(node);
                        const object = {};
                        data.forEach((value, key) => {
                            if (key === 'id-holder') {
                                resource = `http://localhost:8080/professors/edit/${value}`;
                            }
                            object[key] = value;
                        });
                        const success = await postData(object, resource, container, elem);
                        if (success) {
                            container.textContent = 'Данные о преподавателе успешно обновлены!'
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