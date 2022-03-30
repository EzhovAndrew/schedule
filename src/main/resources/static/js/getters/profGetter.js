'use strict';

window.addEventListener('DOMContentLoaded', () => {
    const resource = 'http://localhost:8080/professors/get/';
    const elem = document.querySelector('.modal-body-buttons');
    const container = document.querySelector('#modal-hint');
    const observer = new MutationObserver(async(mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;
                
                if (node.matches('form#FormToGetProfs')){
                    node.addEventListener('submit', async(ev) => {
                        ev.preventDefault();
                        const data = new FormData(node);
                        const object = {};
                        let coursesIds = null;
                        data.forEach((value, key) => {
                            if (key !== 'coursesId') {
                                object[key] = value;
                            } else {
                                if (value) {
                                    coursesIds = value.split(',');
                                    coursesIds = coursesIds.map((x) => {
                                        return parseInt(x, 10);
                                    });
                                }
                            }
                        });
                        const responseData = await getData(resource, container, object, elem);
                        if (responseData.length === 0) {
                            document.querySelector('div.container-md').textContent = 'По вашему запросу ничего не нашлось.';
                        }
                        let flag = 0;
                        responseData.forEach((elem, index) => {
                            if (coursesIds === null || coursesIds.every(element => elem['courses_ids'].includes(element))) {
                                flag = 1;
                                const elemCard = getProfCard(elem);
                                displayCard(elemCard, index);
                            }
                        });
                        if (coursesIds && !flag) {
                            document.querySelector('div.container-md').textContent = 'По вашему запросу ничего не нашлось.';
                        }
                        container.textContent = 'Данные успешно загружены!'
                    });
                }
            }
        });
    });
    const config = {childList: true, subtree: true};
    observer.observe(elem, config);
});